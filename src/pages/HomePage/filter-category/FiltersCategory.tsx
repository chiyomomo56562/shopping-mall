import React from 'react'
import styles from './FiltersCategory.module.scss';
import CategoryTab from './category-tab/CategoryTab';
import { CategoriesName } from '../../../store/categories/categoriesType';

const FiltersCategory = () => {
  return (
    <div className={styles.filter_category}>
        {/* 카테고리 추가, 편집기능도 있으면 좋겠지만... */}
        <CategoryTab text={"모두"} categoryName={CategoriesName.All} />
        <CategoryTab text={"전자기기"} categoryName={CategoriesName.Electronics} />
        <CategoryTab text={"쥬얼리"} categoryName={CategoriesName.Jewelry} />
        <CategoryTab text={"남성의류"} categoryName={CategoriesName.MensClothing} />
        <CategoryTab text={"여성의류"} categoryName={CategoriesName.WomensClothing} />
    </div>
  )
}

export default FiltersCategory
