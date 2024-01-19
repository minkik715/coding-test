-- order은 최종으로 됨 case 절 사용 가능

SELECT BOARD_ID, WRITER_ID, TITLE, PRICE,
       case
           when STATUS="SALE"
               then "판매중"
           when STATUS="RESERVED"
               then "예약중"
           when STATUS="DONE"
               then "거래완료"
           else ""
           end as STATUS
from USED_GOODS_BOARD
where CREATED_DATE = "2022-10-05"
order by BOARD_ID DESC;