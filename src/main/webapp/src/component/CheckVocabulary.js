import React from 'react';
import Banner from './shared-component/Banner'
import { getAllVocabulary } from '../api/VocabularyDataSource';


function CheckVocabulary() {
   getAllVocabulary().then((response)=>console.log(response.data))
  // fetch('https://e-tips-static-site.s3.amazonaws.com/assests/data/vocabulary.json').then(res=>console.log(res.data))

  return (
   <>
      <Banner/>
   </>
  );
}

export default CheckVocabulary;