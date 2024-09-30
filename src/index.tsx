import React from 'react';
import { createRoot } from 'react-dom/client';
import { Provider } from 'react-redux';
// 폴더에서 store요소를 불러오려면 폴더에 store요소를 가진 파일이 있어야한다.
import { store } from './store';
import App from './App';
import reportWebVitals from './reportWebVitals';
import './global.scss';

const container = document.getElementById('root')!;
const root = createRoot(container);

root.render(
  <React.StrictMode>
    <Provider store={store}>
      <App />
    </Provider>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
