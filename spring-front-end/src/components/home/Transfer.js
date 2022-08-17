import React, { Fragment, useEffect, useState } from 'react'
import SenderService from '../services/SenderService';
import BankService from '../services/BankService';
import DatePicker from 'react-datetime';
import moment from 'moment';
import 'react-datetime/css/react-datetime.css';
import MessageService from '../services/MessageService';
import ReceiverService from '../services/ReceiverService';
import TransactionService from '../services/TransactionService';
import { useHistory } from 'react-router-dom';
export default function Transfer() {

    //---------------Sender Auto pop-up-------------------

    const [sender_id, setSender_id] = useState("");
    const [sender, setSender] = useState([]);
    const [error_id, setError_id] = useState("")

    const onSenderId = (e) => {
        const sender_id = e.target.value;
        if (sender_id !== "") {
            setSender_id(sender_id);
            SenderService.getSenderById(sender_id)
                .then((response) => {
                    //console.log(response.data);
                    setSender(response.data);
                    setAmount("");
                    setTransfer_fee("");
                    setUpdated_clear("");
                    setError_id("");
                }
                ).catch((error) => {
                    Object.keys(sender).forEach(function (index) {
                        sender[index] = " ";
                    });
                    if (sender_id === "")
                        setError_id("Please enter Account ID");
                    else
                        setError_id("Account ID not Found. Please enter valid ID");
                    setAmount("");
                    setTransfer_fee("");
                    setUpdated_clear("");
                });
        }
        else {
            window.alert("Enter valid Sender ID");
            setSender_id("");
        }
    }

    //---------------- Bank Details Auto pop-up------------

    const [bic, setBic] = useState("");
    const [bank, setBank] = useState([]);
    const [error_bank, setError_bank] = useState("");

    const onBIC = (e) => {
        const bic = e.target.value;
        setBic(bic);
        BankService.getAllBanksByBic(bic)
            .then((response) => {
                console.log(response.data)
                setBank(response.data);
            }
            ).catch((error) => {
                Object.keys(bank).forEach(function (index) {
                    bank[index] = " ";
                });
                if (bic === "")
                    setError_bank("Please enter BIC");
                else
                    setError_bank("BIC not found. Please enter valid BIC");
            });
    }

    const [message_real, setMessage_real] = useState("CHQB");


    //----------------------------SANCTION LIST----------------------------------

    const [receiver_name, setReceiver_Name] = useState("");
    const [error_receiver, seterror_Receiver] = useState("");
    const [receiver_Id, setreceiver_Id] = useState("");
    const [receiver, setReceiver] = useState([]);
    const Receiver = (e) => {
        const receiver_id = e.target.value;
        if (receiver_id !== "") {
            setreceiver_Id(e.target.value);
            if (receiver_Id !== sender_id) {
                ReceiverService.getReceiverById(receiver_id)
                    .then((response) => {
                        if (response.data) {
                            //console.log(response.data);
                            setReceiver(response.data);
                            setReceiver_Name(receiver.accountholdername);
                        }
                        else
                            seterror_Receiver("");
                    }).catch((error) => {
                        Object.keys(receiver).forEach(function (index) {
                            receiver[index] = " ";
                        });
                        if (receiver_Id === "")
                            setError_id("Please enter Account ID");
                        else
                            setError_id("Account ID not Found. Please enter valid ID");
                    });
            }
            else {
                alert("Sender and Receiver can't be same");
            }
        }
    }
    // const onReceiverId = (e) => {
    //     setreceiver_Id(e.target.value)
    // }

    // const onReceiver = (e) => {

    //     const receiver = e.target.value;
    //     setReceiver_Name(receiver);

    //     ReceiverService.isReceiverExists(receiver_name)
    //         .then(response => {
    //             if (response.data) {
    //                 seterror_Receiver("Cannot initiate Transaction. Receiver present in sanction list.");
    //             }
    //             else
    //                 seterror_Receiver("");

    //         }).catch(error => {
    //             if (receiver_name === "")
    //                 seterror_Receiver("Please enter receiver name.");
    //             else
    //                 seterror_Receiver("Cannot initate Transaction. Receiver present in sanction list.");
    //         })
    // }

    //------------------- AMOUNT----------------------------

    const [amount, setAmount] = useState("");
    const [transfer_fee, setTransfer_fee] = useState("");
    const [updated_clear, setUpdated_clear] = useState(sender.clearbalance);
    const [updated_clear_receiver, setUpdated_clear_receiver] = useState(receiver.clearbalance);
    const [error_amount, setError_amount] = useState("");

    const onAmount = (e) => {
        const amount = e.target.value;
        if (amount > 0) {
            setAmount(amount);
            setTransfer_fee(amount * 0.0025);
            if (sender.overdraftflag) {
                setUpdated_clear(parseFloat(sender.clearbalance) - amount - amount * 0.0025);
                setUpdated_clear_receiver(parseFloat(receiver.clearbalance) + amount);
                setError_amount("");
            }
            else {
                if (sender.clearbalance >= (amount * 1.0025)) {
                    setUpdated_clear(parseFloat(sender.clearbalance) - amount * 1.0025);
                    setUpdated_clear_receiver(parseFloat(receiver.clearbalance) + amount);
                    setError_amount("");

                }
                else {
                    setUpdated_clear("");
                    setUpdated_clear_receiver("");
                    setError_amount("Insufficient Balance. Transfer cann't be initated");
                }
            }
        }
        else {
            setAmount("");
            setTransfer_fee("");
            setUpdated_clear("");
            setUpdated_clear_receiver("");
            window.alert("Amount cannot be negative or zero");
        }
    }



    //-----------------------------MESSAGE INFO-----------------------------------------

    const [message, setMessage] = useState([]);

    useEffect(() => {
        getAllMessages()
    }, []);

    const getAllMessages = () => {
        MessageService.getAllMessages()
            .then(response => {
                setMessage(response.data);
            }).catch(error => {
                console.log(error);
            })
    }



    //------------------------- Date --------------------------------

    const [date, setDate] = useState()

    const yesterday = moment().subtract(1, 'day');
    const tomorrow = moment().add(0, 'day')

    const disableWeekends = current => {
        return current.day() !== 0 && current.day() !== 6 && current.isAfter(yesterday) && current.isBefore(tomorrow);
    }

    //---------------------Transfer Type----------------------------------

    const [transfer_type, setTransfer_type] = useState("Customer Type");

    //-------------------------FORM HANDLING----------------------------

    const history = useHistory();

    const formHandle = (e) => {
        e.preventDefault();

        const error = (error_id === "") ? ((error_bank === "") ? ((error_receiver === "") ? ((error_amount === "" ? true : error_amount)) : error_receiver) : error_bank) : error_id;
        const error1 = (receiver_Id === "") ? "Receiver Account Number" : (receiver_name === "") ? "Receiver Name" : (sender_id === "") ? "Sender ID" : ((bic === "") ? ("bic") : ((amount === "") ? "amount" : true));

        if (error !== true || error1 !== true) {
            if (error !== true)
                window.alert(error);
            else
                window.alert("Please enter " + error1);
        }
        else {
            if (date == null) {
                alert("Enter the date")
            }
            else {
                sender.clearbalance = updated_clear;
                receiver.clearbalance = updated_clear_receiver;
                SenderService.updateSenderDetails(sender_id, sender)
                    .then(response => {
                        if (response.data) {
                            window.alert("Details updated");
                            let clear_balance = updated_clear;
                            let transaction_Id = moment().format("YYYYMMDDHHmmSS");
                            let transfer = transfer_fee;
                            let trans_date = date.format("YYYY-MM-DD");
                            const transaction = {
                                transaction_Id, sender_id, receiver_name,
                                receiver_Id, bic, amount, transfer,
                                clear_balance, trans_date, message_real, transfer_type
                            };

                            console.log(transaction);
                            TransactionService.createTransaction(transaction)
                        }
                        else {
                            window.alert("Transaction Failed, Try again");
                        }
                    }).catch(error => {
                        window.alert(error);
                    })

                ReceiverService.updateReceiverDetails(receiver_Id, receiver);
            }
        }

    }



    //-----------------------INTERFACE-----------------------------------

    return (
        <Fragment>
            <section className="transfer">
                <div className="dart-overlay1">
                    <div className="transfer-inner">
                        <h1 className="large">Transfer Page </h1>
                        <div className="box">
                            <form >
                                <label >Calender Date </label><span style={{ color: "red" }} >*</span>
                                <DatePicker
                                    timeFormat={false}
                                    dateFormat="DD-MM-YYYY"
                                    isValidDate={disableWeekends}
                                    selected={date}
                                    onChange={date => setDate(date)}
                                    required
                                />
                                <label >Customer Id</label> <span style={{ color: "red" }} >*</span>
                                <div className="error">
                                    <input type="number"
                                        className="form-control" id="formGroupExampleInput"
                                        placeholder="Enter Customer ID"
                                        pattern="[0-9]{15}"
                                        value={sender_id}
                                        onChange={onSenderId}
                                        required /><div>

                                        {error_id} </div>
                                </div>

                                <label >Account Holder Name</label>
                                <input
                                    className="form-control-plaintext"
                                    type="text"
                                    id="acc_name"
                                    value={sender.accountholdername}
                                    disabled />
                                <label >Clear Balance</label>
                                <input
                                    type="number"
                                    className="form-control-plaintext"
                                    id="clear_bal"
                                    value={sender.clearbalance}
                                    disabled />
                                <label >BIC</label><span style={{ color: "red" }} >*</span>
                                <div className="error">
                                    <input
                                        type="text"
                                        className="form-control" id="formGroupExampleInput"
                                        placeholder="Enter Receiver's BIC"
                                        value={bic}
                                        onChange={onBIC}
                                        required />
                                    <div>
                                        {error_bank}</div>
                                </div>

                                <label >Institute Name</label>
                                <input
                                    type="text"
                                    className="form-control-plaintext"
                                    id="institute_name"
                                    value={bank.bankname}
                                    disabled />
                                <label >Receiver</label><br></br>
                                <label >Account Holder Number</label><span style={{ color: "red" }} >*</span>
                                <input
                                    type="number"
                                    className="form-control" id="formGroupExampleInput"
                                    placeholder="Receiver's Account Number"
                                    value={receiver_Id}
                                    onChange={Receiver}
                                    pattern="[0-9]{15}" required />
                                <label >Account Holder Name</label>
                                <input
                                    className="form-control-plaintext"
                                    type="text"
                                    id="acc_name"
                                    value={receiver.accountholdername}
                                    disabled />

                                <label >Transfer Type</label>
                                <select id="transfer_type"
                                    className="form-select"
                                    value={transfer_type}
                                    onChange={(e) => {
                                        setTransfer_type(e.target.value);
                                    }}
                                    required>
                                    <option value="customer type">Customer Type</option>
                                    <option value="bank_transfer">Bank Type</option>
                                </select>
                                <label >Message Code</label>
                                <select id="message_code" className="form-select"
                                    value={message_real}
                                    onChange={(e) => {
                                        setMessage_real(e.target.value);
                                    }}
                                    required >
                                    {
                                        message.map((value) => (
                                            <option key={value.messagecode} value={value.messagecode}>
                                                {value.messsagecode}-{value.instruction}
                                            </option>
                                        )
                                        )
                                    }
                                </select>
                                <label >Amount</label><span style={{ color: "red" }} >*</span>
                                <div className="error">
                                    <input
                                        type="number"
                                        className="form-control" id="formGroupExampleInput"
                                        placeholder="Enter Amount"
                                        value={amount}
                                        onChange={onAmount}
                                        required />
                                    <div>
                                        {error_amount}</div>
                                </div>
                                <label >Transfer Fee</label>
                                <input
                                    type="number"
                                    id="transfer_fee"
                                    className="form-control-plaintext"
                                    value={transfer_fee}
                                    disabled />
                                <label >Updated Clear Balance</label>
                                <input
                                    type="number"
                                    id="amount_update"
                                    className="form-control-plaintext"
                                    value={updated_clear}
                                    disabled />

                                <div id="button">
                                    <input
                                        type="submit"
                                        className="btn btn-success"
                                        value="Transfer"
                                        onClick={formHandle}
                                    />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </Fragment>
    )
}
