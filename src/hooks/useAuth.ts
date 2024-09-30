import { useAppSelector } from "./hooks";

export function useAuth() {
    const { id, email, token } = useAppSelector((state) => state.user);
    return {
        isAuth: !!email,
        email,
        id,
        token
    }
}
