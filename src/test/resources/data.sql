drop table if exists ages_search CASCADE ;
drop table if exists search_reservation CASCADE;

create table ages_search (
       search_reservation_entity_search_id varchar(255) not null,
        ages integer
    );

 create table search_reservation (
       search_id varchar(255) not null,
        check_in date,
        check_out date,
        hotel_id varchar(255),
        primary key (search_id)
    );


----- Searches -----
INSERT INTO search_reservation
    (search_id, hotel_id, check_in,  check_out)
    values('123456','ABBA','2025-01-01', '2025-01-02');
COMMIT;
