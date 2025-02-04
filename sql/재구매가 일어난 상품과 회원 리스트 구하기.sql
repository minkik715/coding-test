SELECT USER_ID, PRODUCT_ID  FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) >= 2
ORDER BY 1 ASC, 2 DESC;


select t.user_id, t.product_id
from( select user_id, product_id, count(*) as cnt from ONLINE_SALE group by user_id, product_id)  as t
where t.cnt > 1
order by t.user_id ASC, t.product_id DESC;
