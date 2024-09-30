import React, { useEffect } from 'react'
import styles from './NavCartBlock.module.scss'
import { useAppDispatch, useAppSelector } from '../../../../hooks/hooks'
import { Link } from 'react-router-dom'
import NavCartList from './nav-cart-list/NavCartList'
import { getTotalPrice } from '../../../../store/cart/cartSlice'

const NavCartBlock = () => {

    const { totalPrice, products } = useAppSelector((state) => state.cart);
    const dispatch = useAppDispatch();

    // 이거 왜 쓰는거지....?
    // totalPrice의 값이 변했을 때 화면에 바뀐 값을 출력하기 위해 사용한다.
    useEffect(() => {
        dispatch(getTotalPrice());
    }, [products])

    return (
        <div className={styles.nav_cart_block}>
            {/* 1. 카트안에 있는 물품을 보여줘야한다. */}
            <NavCartList />
            {/* 2. 금액의 총합을 보여줘야한다. => store.cart의 totalPrice를 이용*/}
            <div className={styles.nav_cart_price}>
                <p>합계: ${totalPrice.toFixed(2)}</p>
            </div>
            {/* 3. 장바구니 페이지로 이동하는 링크를 만들어야한다. */}
            <Link to="cart">장바구니로 이동</Link>
        </div>
    )
}

export default NavCartBlock
