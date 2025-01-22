select L.name,
(L.previous_balance+(sum(
    TIMESTAMPDIFF(HOUR,
    STR_TO_DATE(D.entry_time,'%Y-%m-%d %H:%i:%s')
    ,STR_TO_DATE(D.exit_time,'%Y-%m-%d %H:%i:%s')
))*30)) as amount_payble 
from LABORERS L 
JOIN DAILY_HOURS D ON L.id=D.labor_id 
group by L.name,L.previous_balance order by L.name;