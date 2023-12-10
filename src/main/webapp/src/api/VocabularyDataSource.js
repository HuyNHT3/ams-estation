import axios from "axios";

export function getAllVocabulary () {
    return axios.get('https://e-tips-static-site.s3.amazonaws.com/assests/data/vocabulary.json')
}