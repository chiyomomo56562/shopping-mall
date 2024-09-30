import { configureStore } from "@reduxjs/toolkit";
import userReducer from "./user/userSlice";
import categoriesReducer from './categories/categoriesSlice';
import productsReducer from './products/productsSlice';
import productReducer from './products/productSlice';
import cartReducer from './cart/cartSlice';
import orderReducer from './order/orderSlice';
import { useSelector } from "react-redux";

export const store = configureStore({
    reducer: {
       order: orderReducer,
       product: productReducer,
        cart: cartReducer,
        user: userReducer,
        categories: categoriesReducer,
       products: productsReducer
    }
})

// hooks에서 사용할 RootState와 AppDispatch를 store에서 정의하는구나
export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch;
