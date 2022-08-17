import axios from 'axios'

const RECEIVER_BASE_REST_API_URL = "http://localhost:8085/customer"

class ReceiverService {
    isReceiverExists(name) {
        return axios.get(RECEIVER_BASE_REST_API_URL + '/' + name);
    }

    getAllBanksByBic(bic) {
        return axios.get(RECEIVER_BASE_REST_API_URL + '/' + bic);
    }
    getReceiverById(receiverId) {
        console.log("receiver id=" + receiverId)
        //console.log(axios.get(RECEIVER_BASE_REST_API_URL + '/'+receiverId).then((e)=>e.data));
        if (receiverId)
            return axios.get(RECEIVER_BASE_REST_API_URL + '/' + receiverId);
        else
            window.alert("Please enter valid receiver Id");
    }
    updateReceiverDetails(receiverId, receiver) {
        // console.log(axios.get(RECEIVER_BASE_REST_API_URL + '/'+receiverId).then((e)=>e.data));
        return axios.put(RECEIVER_BASE_REST_API_URL + '/' + receiverId, receiver);

    }

}

export default new ReceiverService();