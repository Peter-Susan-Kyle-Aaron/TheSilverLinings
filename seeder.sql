Use silver_lining_db;

Drop TABLE if exists reviews;
Drop TABLE if exists posts;
Drop TABLE if exists users;

# Users
insert into Users (username, password, email, address, photo, role)
values ('Bev Ivan', 'EWqlqmgPB0', 'bivan0@last.fm', '16 Granby Way', 'https://robohash.org/sintbeataeid.png?size=50x50&set=set1', 2),
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
insert into Posts (Title, Description, user_id, Category, Event_Location, Event_Date)
values ('sit', 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', 5, 'Drama', '69 Lakewood Gardens Junction', '5/27/2019 17:46'),
('sed magna at nunc commodo', 'Nulla tempus.', 1, 'Animation|Sci-Fi', '3417 Nova Road', ' 11/13/2018 22:54'),
('tincidunt eu', 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue.', 10, 'Comedy|Musical|Romance', '776 Lillian Point', '9/24/2019 20:15'),
('diam id ornare imperdiet', 'Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 10, 'Drama|Romance', '45 Springs Avenue', '4/1/2019 13:33'),
('platea dictumst', 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', 8, 'Horror|Sci-Fi', '888 Golf View Way', '5/28/2019 17:55'),
('suscipit a feugiat et', 'Aenean lectus.', 10, 'Documentary', '71 Hermina Crossing', '11/25/2019 16:27'),
('nonummy integer non velit', 'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis.', 7, 'Comedy|Musical', '535 Swallow Crossing', '3/11/2019 13:17'),
('sit amet nulla quisque arcu', 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 5, 'Horror|Thriller', '4209 Browning Center', '9/21/2019, 10:11'),
('maecenas tristique est', 'In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 7, 'Comedy|Drama', '17 Eastwood Trail', '11/10/2018 6:15'),
('mus etiam vel augue vestibulum', 'Integer ac neque.', 9, 'Action|Western', '971 Hanover Hill', '10/23/2019 2:20'),
('tincidunt eu felis', 'Pellentesque viverra pede ac diam.', 3, 'Documentary', '786 Hansons Road', '2/24/2019 1:13'),
('nisi', 'Suspendisse potenti. Nullam porttitor lacus at turpis.', 6, 'Comedy|Romance|Western', '5 Division Road', '11/25/2019 15:35'),
('ligula sit', 'Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.', 7, 'Drama|War', '58 Anderson Lane', '3/2/2019 6:36'),
('pretium iaculis', 'Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis.', 1, 'Comedy|Musical|Romance', '18470 Transport Point', '6/14/2019 11:14'),
('magna vestibulum aliquet ultrices', 'Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor.', 3, 'Western', '84479 Cordelia Center', '11/29/2019 19:02'),
('sapien', 'Nullam varius. Nulla facilisi.', 4, 'Documentary', '5 Forest Alley', '9/29/2019 4:01'),
('consequat lectus in', 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 8, 'Crime|Drama|Horror|Thriller', '62875 Grasskamp Center', '3/1/2019 19:22'),
('interdum in', 'Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.', 5, 'Comedy|Drama', '74884 Boyd Parkway', '3/12/2019 23:31'),
('in eleifend quam', 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 5, 'Comedy|Sci-Fi', '74 Old Shore Plaza', '11/23/2019 15:08'),
('felis sed lacus', 'Phasellus id sapien in sapien iaculis congue.', 4, 'Drama', '9 Tony Junction', '8/22/2019 12:33'),
('sapien cum sociis natoque', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum.', 2, 'Children|Comedy', '80027 Upham Lane', '10/9/2018 1:40'),
('ut mauris', 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', 7, 'Horror|Sci-Fi|Thriller', '776 Huxley Trail', '11/7/2018 9:21'),
('tellus in sagittis dui vel', 'Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.', 3, 'Documentary', '44 Columbus Hill', '1/28/2019 21:14'),
('duis', 'Donec semper sapien a libero.', 9, 'Drama|Thriller', '6 5th Junction', '11/7/2018 22:55'),
('penatibus et', 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', 1, 'Horror|Mystery|Sci-Fi|Thriller', '380 Esch Hill', '5/27/2019 23:51'),
('mollis molestie lorem quisque', 'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim.', 3, 'Action|Horror', '4 Killdeer Way', '5/27/2019 6:28'),
('sit', 'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 4, 'Adventure|Children', '0185 Scoville Crossing', '4/8/2019 21:42'),
('non pretium quis lectus', 'Pellentesque viverra pede ac diam.', 9, 'Documentary', '7340 Merrick Park', '3/23/2019 23:38'),
('aenean auctor gravida', 'Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.', 4, 'Comedy|Drama|Thriller', '04 American Ash Circle', '11/4/2018 10:28'),
('sapien cum sociis natoque penatibus', 'Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.', 9, 'Comedy|Drama|Romance', '6 Prentice Drive', '12/2/2018 8:02'),
('habitasse platea dictumst morbi', 'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.', 3, 'Drama', '22477 Shoshone Place', '11/7/2019 16:23'),
('eget congue eget semper rutrum', 'Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', 7, 'Comedy|Crime', '0138 Kenwood Center', '2/17/2019 12:56'),
('in est risus auctor', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue.', 4, 'Comedy', '817 Farwell Junction', '4/27/2019 21:36'),
('vitae ipsum aliquam', 'Nulla mollis molestie lorem.', 3, 'Comedy|Documentary|Drama', '068 Stuart Way', '7/20/2019 12:14'),
('non', 'Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna.', 7, 'Drama|Romance', '7 Mcguire Junction', '9/9/2019 17:04'),
('ac consequat', 'Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus.', 5, 'Adventure|Drama', '210 Esch Lane', '4/5/2019 5:58'),
('aenean lectus pellentesque eget', 'Proin risus. Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', 10, 'Crime|Drama|Thriller', '173 South Plaza', '12/2/2018 6:38'),
('faucibus orci luctus et ultrices', 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.', 2, 'Comedy', '176 Ryan Pass', '5/1/2019 2:33'),
('purus', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum.', 6, 'Comedy', '46 Sachtjen Point', '12/19/2018 3:35'),
('sapien cum sociis natoque penatibus', 'Fusce posuere felis sed lacus.', 10, 'Comedy', '7233 Johnson Terrace', '5/23/2019 6:57'),
('facilisi cras', 'Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum.', 10, 'Fantasy|Mystery|Thriller', '0 Acker Terrace', '6/15/2019 1:29'),
('ligula vehicula', 'In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 4, 'Comedy|Romance|Western', '26287 Bellgrove Place', '4/21/2019 8:51'),
('lorem', 'Maecenas pulvinar lobortis est. Phasellus sit amet erat.', 6, 'Drama', '19533 Springs Place', '8/2/2019 22:53'),
('pretium iaculis diam', 'Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit.', 1, 'Sci-Fi|Thriller', '0 Del Mar Street', '5:012/19/2019 22:53'),
('duis bibendum morbi non', 'Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.', 9, 'Action|Drama|Horror|Thriller', '2475 Arrowood Pass', '10/25/2019 12:56'),
('nunc proin at turpis', 'Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.', 3, 'Drama|Film-Noir|Mystery|Romance', '84290 Clove Road', '7/25/2019 1:47'),
('sed tincidunt eu felis', 'Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.', 3, 'Horror', '66 Pearson Crossing', '5/27/2019 8:48'),
('vitae', 'Morbi a ipsum.', 1, 'Adventure|Documentary', '4 Anthes Road', '9/1/2019 5:41'),
('congue', 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', 3, 'Comedy|Drama', '6 Brickson Park Court', '8/1/2019 12:03'),
('quis turpis eget', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', 9, 'Action|Comedy|Crime', '09 Eggendart Street', '11/16/2019 18:07');


#Reviews

