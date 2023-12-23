import React from 'react';
import Banner from '../shared-component/Banner'
import CheckVocabularyBody from './CheckVocabularyBody';
import ResultTable from './ResultTable';

function CheckVocabulary() {

  return (
   <>
      <Banner/>
      <CheckVocabularyBody/>
      <ResultTable/>
   </>
  );
}

export default CheckVocabulary;