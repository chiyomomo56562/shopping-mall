import React from 'react'
import styles from './Nav.module.scss'
import { Link } from 'react-router-dom'
import { FiLogIn, FiShoppingCart, FiUser } from 'react-icons/fi';
import { useAppDispatch, useAppSelector } from '../../../hooks/hooks';
import NavCartBlock from './nav-cart-block/NavCartBlock';
import { useAuth } from '../../../hooks/useAuth';
import { GoSignOut } from 'react-icons/go';
import { getAuth, signOut } from 'firebase/auth';
import app from '../../../firebase';
import { removeUser } from '../../../store/user/userSlice';
import { removeUserId } from '../../../store/cart/cartSlice';

const Nav = () => {
    const dispatch = useAppDispatch();
    const {products} = useAppSelector((state) => state.cart)
    const { isAuth } = useAuth();
    const auth = getAuth(app);

    const handleSignOut = () => {
        signOut(auth)
            .then(() => {
                dispatch(removeUser());
                dispatch(removeUserId());
            })
            .catch((error) => {
                console.error(error);
            })
    }

  return (
    <nav className={styles.nav}>
        <ul>
            <li>
                <div>
                    {/* 1. 장바구니 구현 */}
                    <Link to={'/cart'}>
                        {/* 이건 왜 있는거야..? */}
                        {" "}
                        <FiShoppingCart />
                    </Link>
                    {/* 장바구니안에 물건이 있다면 물건의 수를 카트 위에 보여줘야한다. */}
                    {products.length > 0 && <b>{products.length}</b>}
                    {/* 호버하면 밑에 장바구니 내역을 보여줘야한다. */}
                    {products.length > 0 &&
                            <div className={styles.nav_hover_cart}>
                                <NavCartBlock />
                            </div>}
                    {/* 호버창안에서도 삭제가 가능해야한다. */}
                </div>
            </li>
            {/* 2. 마이페이지 구현 */}
            <li>
                <div className={styles.counter}>
                    <Link to={"/order"}>
                        {" "}
                        <FiUser title="주문" />
                    </Link>
                </div>
            </li>
            {/* 3. 로그인, 로그아웃 구현 */}
            <li>
                    {isAuth ?
                        <GoSignOut
                            className={styles.nav_sign_out}
                            onClick={handleSignOut}
                            title="로그아웃"
                        />
                        :
                        <Link to={"/login"}>
                            <FiLogIn title="로그인" />
                        </Link>
                    }
                </li>
        </ul>
    </nav>
  )
}

export default Nav
