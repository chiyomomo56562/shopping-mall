import { createSlice } from "@reduxjs/toolkit";

const initialState = localStorage.getItem('user') ?
    JSON.parse(localStorage.getItem('user') || "") : { email: "", token: "", id: "" }


export const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {
        // 계정 생성인가
        setUser: (state, action) => { 
            // 액션의 페이로드로 들어온 정보를 현재 상태에 추가한다.
            state.email = action.payload.email;
            state.token = action.payload.token;
            state.id = action.payload.id;

            localStorage.setItem('user', JSON.stringify(state));
        },
        removeUser: (state) => {
            state.email = "";
            state.token = "";
            state.id = "";

            localStorage.setItem('user', JSON.stringify(state));
        }
    }
})

export const { setUser, removeUser } = userSlice.actions;
export default userSlice.reducer;