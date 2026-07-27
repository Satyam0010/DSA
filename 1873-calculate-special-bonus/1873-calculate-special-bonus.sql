# Write your MySQL query statement below
select employee_id,
    case
        when employee_id%2 != 0 And name not like "M%" then salary
        else 0
    end as bonus
From Employees
Order by employee_id Asc