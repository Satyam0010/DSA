# Write your MySQL query statement below
Update Salary
Set sex = case
when sex = 'm' then 'f'
else 'm'
end;