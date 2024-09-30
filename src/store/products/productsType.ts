export interface IProduct {
    id: number;
    title: string;
    price: number;
    description: string;
    category: string;
    image: string;
    rating: IRating;
    quantity: number;
    total: number;
}

interface IRating {
    rate: number;
    count: number;
}