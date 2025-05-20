use fsd_hex;

-- NO-1 Procedure to fetch all books that are "IN STOCK" and price < given value
DELIMITER $$
CREATE PROCEDURE proc_fetch_book_under_price(IN p_price Double)
BEGIN
	select * from Book WHERE status ='IN STOCK' AND price < p_price;
END;

-- NO-2 Procedure to delete books from a given publication_house

DELIMITER $$
CREATE PROCEDURE proc_delete_by_publication(IN P_publication_house varchar(255))
BEGIN
	DELETE FROM Book where publication_house = p_publication_house;
END;

-- NO-3  Procedure to update price by % based on category
DELIMITER $$
CREATE PROCEDURE proc_update_price(IN p_percent Double, IN p_category varchar(255))
BEGIN
	update Book
    set price =price + (price * p_percent /100)
    where category =p_category;
END;

call proc_fetch_book_under_price(350);
call proc_delete_by_publication('Warner Bros');
call proc_update_price(10,'WAR');
