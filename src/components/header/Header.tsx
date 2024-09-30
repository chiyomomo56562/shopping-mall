import React from 'react'
import styles from './Header.module.scss'
import { Link } from 'react-router-dom'
import Nav from './nav/Nav'

const Header = () => {
  return (
    // 어차피 하나인데 이렇게까지 나눠놓을 필요가 있나..?
    <div className={styles.header}>
        <div className='container'>
            <div className={styles.header_wrapper}>
                <div className={styles.header_logo}>
                    <Link to={"/"}>
                        <h2>Shop</h2>
                    </Link>
                </div>
                <Nav />
            </div>
        </div>
    </div>
  )
}

export default Header
