import React from 'react'
import { IProduct } from '../../../../store/products/productsType'
import styles from './CardItem.module.scss'
import { Link } from 'react-router-dom'
import { useAppDispatch, useAppSelector } from '../../../../hooks/hooks'
import { addToCart } from '../../../../store/cart/cartSlice'
import { AiOutlineDelete } from 'react-icons/ai'
interface Props {
    item: IProduct
}
const CardItem = ({item}:Props) => {
    const { products } = useAppSelector(state => state.cart);
    const productMatching = products.some((product) => product.id === item.id);
    const dispatch = useAppDispatch();

    const addItemToCart = () => {
        dispatch(addToCart(item));
    }

  return (
    <li className={styles.card_item}>
      <Link to={`/product/${item.id}`}>
        <img
          src={item.image}
          width={"80%"}
          height={"200px"}
          alt="product card"
        />
      </Link>

      <h5>{item.title.substring(0, 15)}...</h5>

      <div>
        <button
          disabled={productMatching}
          onClick={() => !productMatching && addItemToCart()}
        >
          {productMatching ? "장바구니에 담긴 제품" : "장바구니에 담기"}
        </button>
        <p>$ {item.price}</p>
      </div>

    </li>
  )
}

export default CardItem
