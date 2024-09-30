// component는 rafce로 함수형 프로그래밍을하네..?
// 이것도 다른 page, store같은 구성 요소랑 비교해봐야겠다.
import React from 'react'
import styles from './Layout.module.scss'
import { Outlet } from 'react-router-dom'
import Header from '../header/Header'
import Footer from '../footer/Footer'

const Layout = () => {
  return (
    <div className = {styles.layout}>
        <Header />
        <Outlet /> {/* 얘는 뭐하는 얘야? */} 
        <Footer />
    </div>
  )
}

export default Layout
