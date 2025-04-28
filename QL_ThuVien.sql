CREATE DATABASE QL_ThuVien;
GO
 -- DROP DATABASE QL_ThuVien
USE QL_ThuVien;
GO

CREATE TABLE nhan_vien (
    id_nhan_vien VARCHAR(10) PRIMARY KEY,
    ten_nhan_vien NVARCHAR(255) NOT NULL,
    chuc_vu NVARCHAR(255),
    so_dien_thoai VARCHAR(15),
    email NVARCHAR(255),
);

CREATE TABLE doc_gia (
    id_doc_gia VARCHAR(10) PRIMARY KEY,
    ten_doc_gia NVARCHAR(255) NOT NULL,
    dia_chi NVARCHAR(255),
    so_dien_thoai VARCHAR(15),
    email NVARCHAR(255),
    -- FOREIGN KEY (id_doc_gia) REFERENCES dang_nhap(id_nguoi_dung)
);

CREATE TABLE dang_nhap (
    id_nguoi_dung VARCHAR(10) PRIMARY KEY,
    mat_khau NVARCHAR(255) NOT NULL,
    quyen_truy_cap INT,
    email NVARCHAR(255) UNIQUE,
    loai_nguoi_dung NVARCHAR(10) CHECK (loai_nguoi_dung IN ('nhan_vien', 'doc_gia')),
    FOREIGN KEY (id_nguoi_dung) REFERENCES nhan_vien(id_nhan_vien),
    FOREIGN KEY (id_nguoi_dung) REFERENCES doc_gia(id_doc_gia)
);

-- Tui mới thêm bảng thể loại sách và sửa lại 1 số thông tin sách á, Chắc sẽ kh ảnh hưởng gì đến bảng của mn đâu ha
CREATE TABLE the_loai (
    id_the_loai VARCHAR(10) PRIMARY KEY,
    ten_the_loai NVARCHAR(255) NOT NULL
);

CREATE TABLE sach (
    id_sach VARCHAR(10) PRIMARY KEY,
    ten_sach NVARCHAR(255) NOT NULL,
    tac_gia NVARCHAR(255) NOT NULL,
    id_the_loai  VARCHAR(10),
    nam_xuat_ban INT,
    so_luong INT DEFAULT 0,	-- so luong sach
    so_luong_con INT DEFAULT 0, -- so luong con lai cua sach sau khi muon. Neu muon het sach thi sach nay khong the muon duoc nua
    hinh_anh_sach VARCHAR(255),
	mo_ta NVARCHAR(1000),

	FOREIGN KEY (id_the_loai) REFERENCES the_loai(id_the_loai)
);


CREATE TABLE muon_sach (
    id_muon VARCHAR(10) PRIMARY KEY,
    id_sach VARCHAR(10),
    id_doc_gia VARCHAR(10),
    ngay_muon DATE NOT NULL,
    ngay_tra DATE,
    id_nhan_vien VARCHAR(10),

    FOREIGN KEY (id_sach) REFERENCES sach(id_sach),
    FOREIGN KEY (id_doc_gia) REFERENCES doc_gia(id_doc_gia),
    FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id_nhan_vien)
);

CREATE TABLE tra_sach (
    id_tra VARCHAR(10) PRIMARY KEY,
    id_muon VARCHAR(10),
    ngay_tra DATE NOT NULL,
    id_nhan_vien VARCHAR(10),

    FOREIGN KEY (id_muon) REFERENCES muon_sach(id_muon),
    FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id_nhan_vien)
);

GO
INSERT INTO nhan_vien VALUES
('NV001', N'Lê Hà Ngọc Thy', N'Thủ thư', '0123456789', N'ngocthy@example.com'),
('NV002', N'Hồ Kiến Thức', N'Quản lý', '0987654321', N'kienthuc@example.com'),
('NV003', N'Nguyễn Hoàng Tuấn', N'Thủ thư', '0123456780', N'hoangtuan@example.com'),
('NV004', N'Trần Văn A', N'Thủ thư', '0987654322', N'tranva@example.com'),
('NV005', N'Nguyễn Văn B', N'Quản lý', '0123456781', N'nguyenb@example.com');

INSERT INTO doc_gia VALUES
('DG001', N'Hoài Linh', N'Đường 123, Quận 1', '0123456789', N'hoailinh@example.com'),
('DG002', N'Trấn Thành', N'Đường 456, Quận 2', '0987654321', N'tranthanh@example.com'),
('DG003', N'Việt Hương', N'Đường 789, Quận 3', '0123456780', N'viethuong@example.com'),
('DG004', N'Hà Hồ', N'Đường 101, Quận 4', '0987654322', N'haho@example.com'),
('DG005', N'Đàm Vĩnh Hưng', N'Đường 202, Quận 5', '0123456781', N'damvinhhung@example.com'),
('DG006', N'Đan Trường', N'Đường 303, Quận 6', '0987654323', N'dantruong@example.com'),
('DG007', N'Thanh Hằng', N'Đường 404, Quận 7', '0123456782', N'thanhhang@example.com'),
('DG008', N'Ngọc Trinh', N'Đường 505, Quận 8', '0987654324', N'ngoctrinh@example.com'),
('DG009', N'Hương Giang', N'Đường 606, Quận 9', '0123456783', N'huonggiang@example.com'),
('DG010', N'Quỳnh Anh', N'Đường 707, Quận 10', '0987654325', N'quynhanh@example.com'),
('DG011', N'Bảo Anh', N'Đường 808, Quận 11', '0123456784', N'baoanh@example.com'),
('DG012', N'Lệ Quyên', N'Đường 909, Quận 12', '0987654326', N'lequyen@example.com');

-- Tui mới bổ sung 1 ít thông tin đăng nhập nữa á
-- Quyền 1 -- Quản Lý
-- Quyền 2 -- Nhân Viên
-- Quyền 3 -- Độc Giả
INSERT INTO dang_nhap VALUES	-- phân vân kh biết độc giả có cần đang nhập không ta ??
('DG001', N'123', 3, N'hoailinh@example.com', 'doc_gia'),
('DG002', N'123', 3, N'tranthanh@example.com', 'doc_gia'),
('DG003', N'123', 3, N'viethuong@example.com', 'doc_gia'),
('DG004', N'123', 3, N'haho@example.com', 'doc_gia'),
('DG005', N'123', 3, N'damvinhhung@example.com', 'doc_gia'),
('DG006', N'123', 3, N'dantruong@example.com', 'doc_gia'),
('DG007', N'123', 3, N'thanhhang@example.com', 'doc_gia'),
('DG008', N'123', 3, N'ngoctrinh@example.com', 'doc_gia'),
('DG009', N'123', 3, N'huonggiang@example.com', 'doc_gia'),
('DG010', N'123', 3, N'quynhanh@example.com', 'doc_gia'),
('DG011', N'123', 3, N'baoanh@example.com', 'doc_gia'),
('DG012', N'123', 3, N'lequyen@example.com', 'doc_gia'),
-- nhân viên
('NV001', N'123', 1, N'ngocthy@example.com', 'nhan_vien'),
('NV002', N'123', 1, N'kienthuc@example.com', 'nhan_vien'),
('NV003', N'123', 2, N'hoangtuan@example.com', 'nhan_vien'),
('NV004', N'123', 2, N'tranva@example.com', 'nhan_vien'),
('NV005', N'123', 2, N'nguyenb@example.com', 'nhan_vien');



INSERT INTO the_loai (id_the_loai, ten_the_loai) VALUES
('TL01', N'Tiểu thuyết'),
('TL02', N'Khoa học'),
('TL03', N'Viễn tưởng'),
('TL04', N'Truyện tranh'),
('TL05', N'Tài liệu học'),
('TL06', N'Trinh thám');

INSERT INTO sach VALUES
('S001', N'Tâm Hồn Cao Thượng', N'Nhà văn Huy Cận', 'TL01', 2010, 15, 15, N'hinh1.jpg', N'Một tác phẩm nổi tiếng về triết lý sống và nhân sinh quan.'),
('S002', N'Đắc Nhân Tâm', N'Dale Carnegie', 'TL02', 1936, 10, 10, N'hinh2.jpg', N'Sách hướng dẫn kỹ năng giao tiếp và thuyết phục người khác.'),
('S003', N'Harry Potter và Hòn Đá Phù Thủy', N'J.K. Rowling', 'TL03', 1997, 8, 8, N'hinh3.jpg', N'Cuộc phiêu lưu của cậu bé phù thủy Harry Potter tại Hogwarts.'),
('S004', N'Truyện Kiều', N'Nguyễn Du', 'TL01', 1820, 12, 12, N'hinh4.jpg', N'Tác phẩm tiêu biểu của văn học Việt Nam, kể về cuộc đời và số phận của Kiều.'),
('S005', N'Nhà Giả Kim', N'Paulo Coelho', 'TL01', 1988, 4, 4, N'hinh5.jpg', N'Cuộc hành trình tìm kiếm kho báu và ý nghĩa cuộc sống.'),
('S006', N'Cô Gái Đến Từ Hôm Qua', N'Nguyễn Nhật Ánh', 'TL01', 2008, 6, 6, N'hinh6.jpg', N'Tình yêu học trò trong sáng và ngọt ngào.'),
('S007', N'Người Đua Diều', N'Khaled Hosseini', 'TL01', 2003, 9, 9, N'hinh7.jpg', N'Câu chuyện về tình bạn và sự phản bội ở Afghanistan.'),
('S008', N'Bí Mật Của Nàng', N'Nguyễn Ngọc Tư', 'TL01', 2007, 3, 3, N'hinh8.jpg', N'Tình yêu và những bí mật trong cuộc sống.'),
('S009', N'Mắt Biếc', N'Nguyễn Nhật Ánh', 'TL01', 1990, 7, 7, N'hinh9.jpg', N'Tình yêu đơn phương và những kỷ niệm đẹp của tuổi học trò.'),
('S010', N'Sống Để Kể', N'Nguyễn Ngọc Tư', 'TL01', 2016, 11, 11, N'hinh10.jpg', N'Những câu chuyện cuộc sống đầy cảm xúc.'),
('S011', N'Bố Già', N'Mario Puzo', 'TL01', 1969, 2, 2, N'hinh11.jpg', N'Câu chuyện về gia đình mafia và quyền lực.'),
('S012', N'Tôi Thấy Hoa Vàng Trên Cỏ Xanh', N'Nguyễn Nhật Ánh', 'TL01', 2015, 5, 5, N'hinh12.jpg', N'Tình yêu quê hương và tuổi thơ đẹp đẽ.'),
('S013', N'Tri Tuệ Xuất Chúng', N'Daniel Kahneman', 'TL02', 2011, 15, 15, N'hinh13.jpg', N'Khám phá các khía cạnh của tư duy con người.'),
('S014', N'Sapiens: Lược Sử Loài Người', N'Yuval Noah Harari', 'TL02', 2011, 10, 10, N'hinh14.jpg', N'Khảo sát lịch sử loài người từ quá khứ đến hiện tại.'),
('S015', N'Hành Trình Về Phương Đông', N'Lương Minh', 'TL01', 1995, 8, 8, N'hinh15.jpg', N'Cuộc hành trình khám phá văn hóa và con người phương Đông.'),
('S016', N'Khi Đàn Ông Bị Lãng Quên', N'Nguyễn Nhật Ánh', 'TL01', 2019, 6, 6, N'hinh16.jpg', N'Tình yêu và những kỷ niệm đau thương.'),
('S017', N'Thế Giới Không Bằng Phẳng', N'Thomas L. Friedman', 'TL02', 2005, 9, 9, N'hinh17.jpg', N'Phân tích sự thay đổi trong nền kinh tế toàn cầu.'),
('S018', N'Dế Mèn Phiêu Lưu Ký', N'Tô Hoài', 'TL04', 1941, 4, 4, N'hinh18.jpg', N'Cuộc phiêu lưu của chú dế mèn đầy hài hước và sâu sắc.'),
('S019', N'Bí Kíp Luyện Thi', N'Nhiều tác giả', 'TL05', 2020, 7, 7, N'hinh19.jpg', N'Hướng dẫn ôn tập cho kỳ thi.'),
('S020', N'Mật Mã Da Vinci', N'Dan Brown', 'TL06', 2003, 3, 3, N'hinh20.jpg', N'Câu chuyện ly kỳ về bí mật và tôn giáo.'),
('S021', N'Trinch Thám Sherlock Holmes', N'Arthur Conan Doyle', 'TL06', 1892, 5, 5, N'hinh21.jpg', N'Những vụ án ly kỳ của thám tử Sherlock Holmes.'),
('S022', N'Tìm Lại Chính Mình', N'Nguyễn Ngọc Tư', 'TL01', 2017, 15, 15, N'hinh22.jpg', N'Cuộc hành trình tìm kiếm bản thân.'),
('S023', N'Người Bán Hàng Vĩ Đại Nhất Thế Giới', N'Og Mandino', 'TL02', 1968, 10, 10, N'hinh23.jpg', N'Những bài học quý giá về kinh doanh và cuộc sống.'),
('S024', N'Nghệ Thuật Tư Duy Tích Cực', N'Norman Vincent Peale', 'TL02', 1952, 8, 8, N'hinh24.jpg', N'Hướng dẫn phát triển tư duy tích cực.'),
('S025', N'Tư Duy Nhanh và Chậm', N'Daniel Kahneman', 'TL02', 2011, 6, 6, N'hinh25.jpg', N'Sự khác biệt giữa tư duy nhanh và chậm.'),
('S026', N'Thế Giới Phẳng', N'Thomas L. Friedman', 'TL02', 2005, 9, 9, N'hinh26.jpg', N'Khám phá sự thay đổi trong thế giới hiện đại.'),
('S027', N'Cẩm Nang Dạy Con', N'Nhiều tác giả', 'TL05', 2019, 4, 4, N'hinh27.jpg', N'Hướng dẫn nuôi dạy trẻ em.'),
('S028', N'Hạt Giống Tâm Hồn', N'Nhiều tác giả', 'TL05', 2015, 7, 7, N'hinh28.jpg', N'Những câu chuyện truyền cảm hứng cho tâm hồn.'),
('S029', N'Bí quyết thành công của người Do Thái', N'Nhiều tác giả', 'TL02', 2008, 5, 5, N'hinh29.jpg', N'Những bài học thành công từ người Do Thái.'),
('S030', N'Sống Chậm', N'Nguyễn Ngọc Tư', 'TL01', 2021, 3, 3, N'hinh30.jpg', N'Khám phá giá trị của sự chậm lại trong cuộc sống.');

INSERT INTO muon_sach VALUES
('M001', 'S001', 'DG001', '2023-01-01', NULL, 'NV001'),
('M002', 'S002', 'DG002', '2023-01-02', NULL, 'NV004'),
('M003', 'S003', 'DG003', '2023-01-03', NULL, 'NV002'),
('M004', 'S004', 'DG004', '2023-01-04', NULL, 'NV004'),
('M005', 'S005', 'DG005', '2023-01-05', NULL, 'NV001'),
('M006', 'S006', 'DG006', '2023-01-06', NULL, 'NV005'),
('M007', 'S007', 'DG007', '2023-01-07', NULL, 'NV002'),
('M008', 'S008', 'DG008', '2023-01-08', NULL, 'NV005'),
('M009', 'S009', 'DG009', '2023-01-09', NULL, 'NV002'),
('M010', 'S010', 'DG010', '2023-01-10', NULL, 'NV003'),
('M011', 'S011', 'DG011', '2023-01-11', NULL, 'NV001'),
('M012', 'S012', 'DG012', '2023-01-12', NULL, 'NV004'),
('M013', 'S013', 'DG001', '2023-01-13', NULL, 'NV005'),
('M014', 'S014', 'DG002', '2023-01-14', NULL, 'NV002'),
('M015', 'S015', 'DG003', '2023-01-15', NULL, 'NV003');

INSERT INTO tra_sach VALUES
('T001', 'M001', '2023-01-15', 'NV001'),
('T002', 'M002', '2023-01-16', 'NV003'),
('T003', 'M003', '2023-01-17', 'NV002'),
('T004', 'M004', '2023-01-18', 'NV001'),
('T005', 'M005', '2023-01-19', 'NV003'),
('T006', 'M006', '2023-01-20', 'NV002'),
('T007', 'M007', '2023-01-21', 'NV005'),
('T008', 'M008', '2023-01-22', 'NV002');

