// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyDE7Xu1U1IRmXVL47-kzUDS0-Bzus4OrFg",
  authDomain: "shoppint-mall.firebaseapp.com",
  projectId: "shoppint-mall",
  storageBucket: "shoppint-mall.appspot.com",
  messagingSenderId: "424873128143",
  appId: "1:424873128143:web:aa1f5fb1cbe1226fbd47ba"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

export default app;