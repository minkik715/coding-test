-- HAVING은 group 후 연산 ROUND는 반올림 DATEDIFF는 날짜 뺴기

SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) as AVG_RENTAL_DATE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVG_RENTAL_DATE >= 7
ORDER BY AVG_RENTAL_DATE DESC, CAR_ID DESC