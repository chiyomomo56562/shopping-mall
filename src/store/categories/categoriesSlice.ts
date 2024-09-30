import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { CategoriesName } from "./categoriesType";

// default상태는 모든 카테고리 상품을 다 보여주는 것
const initialState = CategoriesName.All;

export const categoriesSlice = createSlice({
    name: "category",
    initialState,
    reducers: {
        // 원래 state와 action이 들어와야하지만 현재 state가 필요하지 않아 _,로 표시해준것임
        setActiveCategory: (_, action: PayloadAction<CategoriesName>) => action.payload
    }
})


export const { setActiveCategory } = categoriesSlice.actions;
export default categoriesSlice.reducer;