import React from 'react'
import { CategoriesName } from '../../../../store/categories/categoriesType'
import { useAppDispatch, useAppSelector } from '../../../../hooks/hooks';
import { setActiveCategory } from '../../../../store/categories/categoriesSlice';
import styles from './CategoryTab.module.scss'

interface Props {
    text: string;
    categoryName: CategoriesName
}

const CategoryTab = ({text, categoryName}:Props) => {
    const dispatch = useAppDispatch();
    const category = useAppSelector((state) => state.categories)

    const getActiveCategory = () => {
        // active category 교체
        dispatch(setActiveCategory(categoryName))
    }
  return (
    <button
        className={
            // 현재 active상태에 따라 다른 css를 적용하기 위해
            categoryName === category
                ? styles.active_category
                : styles.category_button
        }
        onClick={getActiveCategory}
    >
        {text}
    </button>
  )
}

export default CategoryTab
