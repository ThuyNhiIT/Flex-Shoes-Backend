use ShoesDB

INSERT INTO Brand (brand_id, brand_name, [description]) VALUES 
('BR001', 'Nike', 'Leading global brand known for innovative athletic footwear'),
('BR002', 'Adidas', 'Popular sportswear brand with a focus on performance and lifestyle shoes'),
('BR003', 'Puma', 'International brand with a variety of casual and athletic shoes'),
('BR004', 'NewBalance', 'Brand specializing in running and casual footwear with superior comfort'),
('BR005', 'Reebok', 'Iconic sports brand known for its fitness and training footwear'),
('BR006', 'Converse', 'Classic American brand famous for its Chuck Taylor All-Star sneakers'),
('BR007', 'Vans', 'Skateboarding brand with a strong presence in youth culture'),
('BR008', 'UnderArmour', 'Athletic brand focused on performance and innovation in sportswear'),
('BR009', 'ASICS', 'Japanese brand recognized for high-quality running and athletic shoes'),
('BR010', 'Fila', 'Global sportswear brand with a blend of casual and athletic styles');

select * from brand

INSERT INTO color (color_name) VALUES 
('Red'),
('Blue'),
('Green'),
('Black'),
('White'),
('Gray'),
('Yellow'),
('Pink'),
('Brown'),
('Purple');

select * from color

INSERT INTO product_category (category_id, category_name, [description]) VALUES
('CT001', 'Men Shoes', 'Category for all men''s shoes'),
('CT002', 'Women Shoes', 'Category for all women''s shoes'),
('CT003', 'Kids Shoes', 'Category for all kids'' shoes'),
('CT004', 'Sports Shoes', 'Category for sports shoes and sneakers'),
('CT005', 'Casual Shoes', 'Category for casual and everyday wear shoes');

select * from product_category

INSERT INTO Size (size_name) VALUES 
('S'),
('M'),
('L'),
('XL'),
('XXL'),
('36'),
('37'),
('38'),
('39'),
('40'),
('41'),
('42'),
('43'),
('44'),
('45');

select * from size

INSERT INTO Product (product_name, [description], original_price, [status], sale_price, vat, category_id, brand_id, [gender]) VALUES
                                                                                                                                  ('Nike Air Max', 'Comfortable and stylish sneakers', 120.00, 'Available', 5.00, 10.0, 'CT004', 'BR001', 'MEN'),
                                                                                                                                  ('Nike Air Force 1 Shadow', 'Comfortable and stylish sneakers', 120.00, 'Available', 10.00, 10.0, 'CT004', 'BR001', 'MEN'),
                                                                                                                                  ('Adidas Ultraboost', 'High-performance running shoes', 150.00, 'Available', 15.00, 10.0, 'CT004', 'BR002', 'MEN'),
                                                                                                                                  ('Puma RS-X', 'Retro-style chunky sneakers', 110.00, 'Available', 20.00, 10.0, 'CT005', 'BR003', 'MEN'),
                                                                                                                                  ('Converse All Star Trekwave', 'Classic high-top sneakers', 60.00, 'Available', 25.00, 10.0, 'CT005', 'BR006', 'WOMEN'),
                                                                                                                                  ('New Balance 550', 'Casual and comfortable sneakers', 80.00, 'Available', 30.00, 10.0, 'CT005', 'BR004', 'MEN'),
                                                                                                                                  ('Vans Old Skool Stackform Canvas Black', 'Popular skateboarding shoes', 50.00, 'Available', 35.00, 10.0, 'CT005', 'BR007', 'MEN'),
                                                                                                                                  ('ASICS Gel-Game 9', 'Supportive running shoes', 140.00, 'Available', 40.00, 10.0, 'CT004', 'BR009', 'MEN'),
                                                                                                                                  ('Under Armour Infinite Pro 3027190-101', 'Lightweight training shoes', 100.00, 'Available', 45.00, 10.0, 'CT004', 'BR008', 'WOMEN'),
                                                                                                                                  ('Reebok DMX Series 2K DV9724', 'Cross-training shoes for gym', 130.00, 'Available', 50.00, 10.0, 'CT004', 'BR005', 'WOMEN'),
                                                                                                                                  ('Fila Unisex Scanline Mule', 'Chunky retro-style sneakers', 90.00, 'Available', 55.00, 10.0, 'CT005', 'BR010', 'Unisex'),
                                                                                                                                  ('Fila Unisex Como Mule', 'Chunky retro-style sneakers', 90.00, 'Available', 60.00, 10.0, 'CT005', 'BR010', 'Unisex');

select * from product

INSERT INTO Images (product_id, [image]) VALUES
(1, 'https://localhost:8080/images/nike-air-max-trang-xanh-1.png'),
(1, 'https://localhost:8080/images/nike-air-max-trang-xanh-2.png'),
(1, 'https://localhost:8080/images/nike-air-max-trang-xanh-3.png'),
(1, 'https://localhost:8080/images/nike-air-max-trang-xanh-4.png'),
(1, 'https://localhost:8080/images/nike-air-max-trang-xanh-5.png'),
(2, 'https://localhost:8080/images/nike-air-force1-do-trang-1.png'),
(2, 'https://localhost:8080/images/nike-air-force1-do-trang-2.png'),
(2, 'https://localhost:8080/images/nike-air-force1-do-trang-3.png'),
(2, 'https://localhost:8080/images/nike-air-force1-do-trang-4.png'),
(2, 'https://localhost:8080/images/nike-air-force1-do-trang-5.png'),
(3, 'https://localhost:8080/images/adidas-ultraboost01-trang-1.png'),
(3, 'https://localhost:8080/images/adidas-ultraboost01-trang-2.png'),
(3, 'https://localhost:8080/images/adidas-ultraboost01-trang-3.png'),
(3, 'https://localhost:8080/images/adidas-ultraboost01-trang-4.png'),
(3, 'https://localhost:8080/images/adidas-ultraboost01-trang-5.png'),
(4, 'https://localhost:8080/images/puma-rs-x-trang-1.jpg'),
(4, 'https://localhost:8080/images/puma-rs-x-trang-2.jpg'),
(4, 'https://localhost:8080/images/puma-rs-x-trang-3.jpg'),
(4, 'https://localhost:8080/images/puma-rs-x-trang-4.jpg'),
(4, 'https://localhost:8080/images/puma-rs-x-trang-5.jpg'),
(5, 'https://localhost:8080/images/converse-all-star-trekwave-hi-trang-1.png'),
(5, 'https://localhost:8080/images/converse-all-star-trekwave-hi-trang-2.png'),
(5, 'https://localhost:8080/images/converse-all-star-trekwave-hi-trang-3.png'),
(5, 'https://localhost:8080/images/converse-all-star-trekwave-hi-trang-4.png'),
(5, 'https://localhost:8080/images/converse-all-star-trekwave-hi-trang-5.png'),
(6, 'https://localhost:8080/images/new-balance-550-white-1.jpg'),
(6, 'https://localhost:8080/images/new-balance-550-white-2.jpg'),
(6, 'https://localhost:8080/images/new-balance-550-white-3.jpg'),
(6, 'https://localhost:8080/images/new-balance-550-white-4.jpg'),
(6, 'https://localhost:8080/images/new-balance-550-white-5.jpg'),
(7, 'https://localhost:8080/images/vans-old-skool-stackform-canvas-black-1.jpg'),
(7, 'https://localhost:8080/images/vans-old-skool-stackform-canvas-black-2.jpg'),
(7, 'https://localhost:8080/images/vans-old-skool-stackform-canvas-black-3.jpg'),
(7, 'https://localhost:8080/images/vans-old-skool-stackform-canvas-black-4.jpg'),
(7, 'https://localhost:8080/images/vans-old-skool-stackform-canvas-black-5.jpg'),
(8, 'https://localhost:8080/images/asics-gel-game9-white-1.jpg'),
(8, 'https://localhost:8080/images/asics-gel-game9-white-2.jpg'),
(8, 'https://localhost:8080/images/asics-gel-game9-white-3.jpg'),
(8, 'https://localhost:8080/images/asics-gel-game9-white-4.jpg'),
(8, 'https://localhost:8080/images/asics-gel-game9-white-5.jpg'),
(9, 'https://localhost:8080/images/under-armour-infinite-pro-3027190-101-mautim-1.jpg'),
(9, 'https://localhost:8080/images/under-armour-infinite-pro-3027190-101-mautim-2.jpg'),
(9, 'https://localhost:8080/images/under-armour-infinite-pro-3027190-101-mautim-3.jpg'),
(9, 'https://localhost:8080/images/under-armour-infinite-pro-3027190-101-mautim-4.jpg'),
(9, 'https://localhost:8080/images/under-armour-infinite-pro-3027190-101-mautim-5.jpg'),
(10, 'https://localhost:8080/images/reebok-dmx-series-2k-dv9724-mau-trang-1.jpg'),
(10, 'https://localhost:8080/images/reebok-dmx-series-2k-dv9724-mau-trang-2.jpg'),
(10, 'https://localhost:8080/images/reebok-dmx-series-2k-dv9724-mau-trang-3.jpg'),
(10, 'https://localhost:8080/images/reebok-dmx-series-2k-dv9724-mau-trang-4.jpg'),
(10, 'https://localhost:8080/images/reebok-dmx-series-2k-dv9724-mau-trang-5.jpg'),
(11, 'https://localhost:8080/images/fila-unisex-scanline-mule-black-1.jpg'),
(11, 'https://localhost:8080/images/fila-unisex-scanline-mule-black-2.jpg'),
(11, 'https://localhost:8080/images/fila-unisex-scanline-mule-black-3.jpg'),
(11, 'https://localhost:8080/images/fila-unisex-scanline-mule-black-4.jpg'),
(11, 'https://localhost:8080/images/fila-unisex-scanline-mule-black-5.jpg'),
(12, 'https://localhost:8080/images/fila-unisex-como-mule-black-1.jpg'),
(12, 'https://localhost:8080/images/fila-unisex-como-mule-black-2.jpg'),
(12, 'https://localhost:8080/images/fila-unisex-como-mule-black-3.jpg'),
(12, 'https://localhost:8080/images/fila-unisex-como-mule-black-4.jpg'),
(12, 'https://localhost:8080/images/fila-unisex-como-mule-black-5.jpg');


select * from images

INSERT INTO quantity (product_id, color_id, size_id, quantity) VALUES
(1, 2, 6, 50),
(1, 2, 7, 50),
(1, 2, 8, 50),
(1, 2, 9, 50),
(2, 1, 10, 50),
(2, 1, 11, 50),
(2, 1, 12, 50),
(3, 5, 10, 50),
(3, 5, 11, 50),
(3, 5, 12, 50),
(4, 5, 10, 50),
(4, 5, 11, 50),
(4, 5, 12, 50),
(5, 5, 10, 50),
(5, 5, 11, 50),
(5, 5, 12, 50),
(6, 5, 10, 50),
(6, 5, 11, 50),
(6, 5, 12, 50),
(7, 4, 10, 50),
(7, 4, 11, 50),
(7, 4, 12, 50),
(8, 5, 10, 50),
(8, 5, 11, 50),
(8, 5, 12, 50),
(9, 10, 10, 50),
(9, 10, 11, 50),
(9, 10, 12, 50),
(10, 5, 10, 50),
(10, 5, 11, 50),
(10, 5, 12, 50),
(11, 5, 10, 50),
(11, 5, 11, 50),
(11, 5, 12, 50),
(12, 4, 10, 50),
(12, 4, 11, 50),
(12, 4, 12, 50);

select * from quantity

select * from color where color_id = 2
select * from size where size_id = 6

select p.product_name, q.quantity from product p join quantity q on p.product_id = q.product_id where color_id = 2 and size_id = 6
