with t AS (SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE FROM FOOD_PRODUCT
           where CATEGORY in ('과자', '국', '김치', '식용유')
           GROUP BY CATEGORY)


-- 코드를 입력하세요
SELECT f.CATEGORY, f.PRICE AS MAX_PRICE, PRODUCT_NAME FROM FOOD_PRODUCT as f
join t
     on t.CATEGORY = f.CATEGORY and t.MAX_PRICE = f.PRICE
ORDER BY MAX_PRICE DESC
;