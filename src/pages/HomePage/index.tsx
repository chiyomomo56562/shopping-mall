import React from 'react'
import FiltersCategory from './filter-category/FiltersCategory'
import CountProducts from './count-products/CountProducts'
import CardList from './card-list/CardList'

const HomePage = () => {
  return (
    <div className='page'>
        <div className='container'>
            <h1>Products</h1>
            {/* 1. 카테고리 선택 */}
            <FiltersCategory />
            {/* 2. 상품 갯수 출력 */}
            <CountProducts />
            {/* 3. 상품 목록 출력 */}
            <CardList />
        </div>
    </div>
  )
}

export default HomePage
