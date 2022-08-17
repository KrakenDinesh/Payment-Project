import axios from 'axios'

const BANK_BASE_REST_API_URL = "http://localhost:8085/banks"

class BankService{
    getAllBanks(){
        return axios.get(BANK_BASE_REST_API_URL);
    }

    getAllBanksByBic(bic){
        // console.log(axios.get(BANK_BASE_REST_API_URL + '/'+bic).then((e)=>e.data))
        return axios.get(BANK_BASE_REST_API_URL + '/'+bic);
    }

}

export default new BankService();