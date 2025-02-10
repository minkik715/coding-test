with USERS AS (SELECT u.USER_ID, count(*) as cnt from USED_GOODS_USER  as u
                                                          join USED_GOODS_BOARD  as b
                                                               on u.USER_ID = b.WRITER_ID
               group by u.USER_ID
               having cnt > 2)

select U.USER_ID,
       U.NICKNAME, concat(U.CITY, " ", U.STREET_ADDRESS1, " ", U.STREET_ADDRESS2 ) as '전체주소',
        concat(substring(U.TLNO, 1, 3) , "-", substring(U.TLNO, 4, 4) ,"-", substring(U.TLNO, 8, 4)) as '전화번호'	from USERS as OU
                                                                                                                           join USED_GOODS_USER as U
                                                                                                                                on OU.USER_ID = U.USER_ID
ORDER BY U.USER_ID DESC
;