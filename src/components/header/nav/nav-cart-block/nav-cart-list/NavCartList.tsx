import React from 'react'
import styles from './NavCartList.module.scss'
import { useAppSelector } from '../../../../../hooks/hooks'
import NavCartItem from './nav-cart-item/NavCartItem';
import { IProduct } from '../../../../../store/products/productsType';

const NavCartList = () => {
    const {products} = useAppSelector((state) => state.cart);
  return (
    <div className={styles.nav_cart_list}>
        {
            // 카트 안의 아이템을 출력해줘야한다.
            // item에 IProduct로 명시적으로 주긴했는데..오류날려나..?
            products.map((item:IProduct) => (
                <NavCartItem key={item.id} item = {item} />
            ))
        }
    </div>
  )
}

export default NavCartList
