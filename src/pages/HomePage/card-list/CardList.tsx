import React, { useEffect } from 'react'
import { useAppDispatch, useAppSelector } from '../../../hooks/hooks'
import styles from './CardList.module.scss'
import { IProduct } from '../../../store/products/productsType'
import CartItem from './card-item/cardItem'
import { fetchProducts } from '../../../store/products/productsSlice'
import CardSkeleton from '../card-skeleton/CardSkeleton'

const CardList = () => {
  const dispatch = useAppDispatch();
  
  const {products, isLoading} = useAppSelector((state) => state.products)
  const category = useAppSelector(state => state.categories)
  
  useEffect(() => {
    dispatch(fetchProducts(category?.toLowerCase()));
  }, [category])

  //로딩 중에 보여줄 html
  //이런식으로 로딩중일 때 아닐 때 나눌 수 있구나.. 
  if (isLoading) return <CardSkeleton />;

  return (
    <div className={styles.cart_list}>
      {/* 여러개의 아이템을 보여줘야한다. */}
      {products.map((product:IProduct) =>(
        <CartItem key={product.id} item = {product}/>
      ))
      }
    </div>
  )
}

export default CardList
