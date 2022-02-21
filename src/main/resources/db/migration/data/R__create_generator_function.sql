-- FUNCTION ITEM
CREATE OR REPLACE FUNCTION ItemGenerator(id BIGINT,
                                         code varchar,
                                         name varchar,
                                         price DECIMAL,
                                         stock int)
RETURNS VOID AS $$
	#variable_conflict use_variable
	BEGIN
	INSERT INTO item(id,
	                 code,
                     name,
                     price,
                     stock)
		SELECT
			id, code, name, price, stock
				WHERE NOT EXISTS (SELECT x.code FROM item x WHERE x.code = code OR x.id = id);
	END;
$$ LANGUAGE plpgsql;
