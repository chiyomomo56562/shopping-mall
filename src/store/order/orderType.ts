import { IProduct } from "../products/productsType";

export interface IOrder {
    id: string;
    userId: string;
    totalPrice: number;
    products: IProduct[]
}