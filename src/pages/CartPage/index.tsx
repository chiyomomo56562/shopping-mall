import React from 'react'
import CartEmpty from '../../components/cart-empty/CartEmpty';
import { useAppSelector } from '../../hooks/hooks';
import CartList from './cart-list/CartList';
import Checkout from './checkout/Checkout';

const CartPage = () => {
  const { products } = useAppSelector((state) => state.cart);
  return (
    <div className='page'>
      {/* 1. 장바구니가 비어있는 경우 */}
      {!products.length ? (
        <CartEmpty title="Cart" />
      ) : (
        <div className='container'>
          <h1>장바구니</h1>
          {/* 장바구니에 있는 아이템들을 출력한다. */}
          <CartList />
          {/* 아이템들의 총액 합계와 결제 버튼 */}
          <Checkout />
        </div>
      )}
    </div >
  )
}

export default CartPage