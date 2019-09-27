Use silver_lining_db;

Drop TABLE if exists post_workers;
Drop TABLE if exists reviews;
Drop TABLE if exists posts;
Drop TABLE if exists users;

# Users

Select * from Users;

insert into Users (username, password, email, address, photo, role)
values ('kyle','$2a$10$Np9uN3PKPI10iYO1Yv.de.vHgWaJ/VunlS.uAV9eD0d7A044Uj8V2','kyle@mail.com','1234 Nowhereville','',1);
('Bev Ivan', 'EWqlqmgPB0', 'bivan0@last.fm', '16 Granby Way', 'https://robohash.org/sintbeataeid.png?size=50x50&set=set1', 2),
('Sebastien Devereux', 'JKwYFR', 'sdevereux1@blogger.com', '8 Laurel Hill', 'https://robohash.org/dolorumrepellendusut.jpg?size=50x50&set=set1', 2),
('Kristen Dyett', '1k8pa5Y5UWDp', 'kdyett2@slideshare.net', '71039 Cody Street', 'https://robohash.org/natusquiesse.bmp?size=50x50&set=set1', 1),
('Mace Bucke', 'J8B0JYH4zaB8', 'mbucke3@ning.com', '3 Portage Pass', 'https://robohash.org/nullaquiavel.bmp?size=50x50&set=set1', 2),
('Maryellen de Guerre', 'TwQOBcsf', 'mde4@ucsd.edu', '8 Stoughton Court', 'https://robohash.org/culpasequiet.png?size=50x50&set=set1', 2),
('Glori Hastwell', 'I7eeHKH7OIN', 'ghastwell5@utexas.edu', '62855 Anthes Hill', 'https://robohash.org/magnamnamet.png?size=50x50&set=set1', 2),
('Early Brewood', 'PrZrmz', 'ebrewood6@washington.edu', '64 Chive Hill', 'https://robohash.org/nobisteneturporro.bmp?size=50x50&set=set1', 1),
('Harwilll Worgan', 'rZEVpfvwBO7', 'hworgan7@wsj.com', '1852 Eggendart Circle', 'https://robohash.org/ametquieum.bmp?size=50x50&set=set1', 1),
('Brear Chaffin', '481qCxV', 'bchaffin8@vkontakte.ru', '33 Shasta Way', 'https://robohash.org/repellatdoloribusvelit.png?size=50x50&set=set1', 2),
('Evelyn Murney', 'QYe08m3z85f', 'emurney9@youtu.be', '365 Helena Hill', 'https://robohash.org/sequiaperiamculpa.png?size=50x50&set=set1', 1);


#Posts

# insert into Posts (body, user_id, Category, Location)
# values

#Reviews

