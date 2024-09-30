import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { IProduct } from "./productsType";

// fakestoreapi.com에서 정보를 가져와야한다.
// 카테고리에 따른 아이템 정보를 가져오는건가
export const fetchProducts = createAsyncThunk(
    "products/fetchProducts",
    async (category: string, thunkAPI) => {
        try {
            let response;
            if (category) {   
                response = await axios.get<IProduct[]>(`https://fakestoreapi.com/products/category/${category}`);
                // console.log(response);
                response.data.map( (data:IProduct) => {
                    data = { ...data, quantity: 0, total: 0}
                });
            } else {
                response = await axios.get<IProduct[]>("https://fakestoreapi.com/products");
            }

            return response.data; //payload
        } catch (error) {
            return thunkAPI.rejectWithValue("Error loading products");
        }
    }
)

type ProductsType = {
    products: IProduct[];
    isLoading: boolean;
    error: string;
}

const initialState: ProductsType = {
    products: [],
    isLoading: false,
    error: "",
}

export const productsSlice = createSlice({
    name: 'products',
    initialState,
    reducers: {},
    // extraReducers를 사용하면 비동기 액션을 처리할 수 있다.
    extraReducers: (builder) => {
        builder
            .addCase(fetchProducts.pending, (state) => {
                state.isLoading = true; //데이터 요청중
            })
            .addCase(fetchProducts.fulfilled, (state, action) => {
                state.isLoading = false; // 요청 성공시 데이터 업로드
                state.products = action.payload;
            })
            .addCase(fetchProducts.rejected, (state, action) => {
                state.isLoading = false; //요청 실패시 에러처리
                state.error = action.payload as string;
            })
    }
})

export default productsSlice.reducer;