-- 회원
DROP TABLE IF EXISTS member RESTRICT;

-- 고객센터 1:1문의
DROP TABLE IF EXISTS cs1 RESTRICT;

-- 고객센터 공지사항
DROP TABLE IF EXISTS cs_notice RESTRICT;

-- 자주묻는질문
DROP TABLE IF EXISTS qna RESTRICT;

-- 파티원모집
DROP TABLE IF EXISTS party RESTRICT;

-- 참여자
DROP TABLE IF EXISTS volunteer RESTRICT;

-- 팔로잉/팔로우
DROP TABLE IF EXISTS follower RESTRICT;

-- 고객센터 첨부파일
DROP TABLE IF EXISTS cs1_file RESTRICT;

-- 파티원모집좋아요
DROP TABLE IF EXISTS party_like RESTRICT;

-- 댓글
DROP TABLE IF EXISTS party_reply RESTRICT;

-- 이벤트
DROP TABLE IF EXISTS event RESTRICT;

-- 알림
DROP TABLE IF EXISTS alarm RESTRICT;

-- 입장권구매
DROP TABLE IF EXISTS ticket RESTRICT;

-- 리뷰
DROP TABLE IF EXISTS review RESTRICT;

-- 신고
DROP TABLE IF EXISTS report RESTRICT;

-- 피드
DROP TABLE IF EXISTS feed RESTRICT;

-- 댓글
DROP TABLE IF EXISTS feed_reply RESTRICT;

-- 리뷰이미지
DROP TABLE IF EXISTS rv_file RESTRICT;

-- 질문유형
DROP TABLE IF EXISTS q_state RESTRICT;

-- 태그
DROP TABLE IF EXISTS tag RESTRICT;

-- 파티원모집태그
DROP TABLE IF EXISTS partytag RESTRICT;

-- 피드 첨부파일
DROP TABLE IF EXISTS feed_file RESTRICT;

-- 파티게시판 첨부파일
DROP TABLE IF EXISTS party_file RESTRICT;

-- 이벤트 첨부파일
DROP TABLE IF EXISTS event_file RESTRICT;

create table cs_notice
(
    csno       int auto_increment comment '공지번호'
        primary key,
    title      varchar(200) not null comment '제목',
    cont       mediumtext   not null comment '내용',
    createdate date         not null comment '작성일',
    filename   varchar(200) null comment '첨부파일명'
)
    comment '고객센터 공지사항';

create table member
(
    mno         int auto_increment comment '회원번호'
        primary key,
    id          varchar(40)          not null comment '아이디(이메일)',
    pwd         varchar(100)         not null comment '비밀번호',
    grade       tinyint(1) default 0 not null comment '회원등급(0:일반/1:관리자)',
    name        varchar(50)          not null comment '이름',
    nick        varchar(20)          not null comment '닉네임',
    birth       date                 not null comment '생년월일',
    tel         varchar(30)          not null comment '휴대폰',
    gender      varchar(10)          not null comment '성별',
    createddate date                 not null comment '가입일',
    post        varchar(15)          not null comment '우편번호',
    addr        varchar(255)         not null comment '기본주소',
    subaddr     varchar(255)         null comment '상세주소',
    interest    varchar(20)          null comment '관심사',
    outstate    tinyint(1) default 0 not null comment '탈퇴여부(0:기존 회원/1:탈퇴한 회원)',
    outdate     date                 null comment '탈퇴일',
    thumbnail   varchar(250)         null comment '프로필사진',
    intro       varchar(150)         null comment '자기소개'
)
    comment '회원';

create table alarm
(
    ano      int        not null comment '알림번호'
        primary key,
    cont     mediumtext not null comment '알림내용',
    time     datetime   not null comment '알림시간',
    readtime datetime   not null comment '읽은시간',
    mno      int        not null comment '회원번호',
    constraint FK_member_TO_alarm
        foreign key (mno) references member (mno)
)
    comment '알림';

create table event
(
    eno        int auto_increment comment '게시글 번호'
        primary key,
    mno        int                         not null comment '회원번호',
    title      varchar(200)                not null comment '제목',
    cont       mediumtext                  not null comment '내용',
    date       date                        not null comment '날짜',
    loc        varchar(255)                not null comment '장소명',
    post       varchar(15)                 null comment '장소우편번호',
    addr       varchar(255)                not null comment '장소주소',
    viewcnt    int                         null comment '조회수',
    pub        tinyint(1)  default 0       null comment '공개여부',
    createdate datetime                    not null comment 'createdate',
    thumbnail  varchar(250)                null comment 'thumbnail',
    tname      varchar(20) default 'event' null,
    constraint FK_member_TO_event
        foreign key (mno) references member (mno)
)
    comment '이벤트';

create table event_file
(
    efileno  int auto_increment comment '첨부파일 번호'
        primary key,
    eno      int          not null comment '게시글 번호',
    filename varchar(200) null comment '첨부파일명',
    path     varchar(200) not null comment '파일 경로',
    savename varchar(200) null comment '저장파일명',
    constraint FK_event_TO_event_file
        foreign key (eno) references event (eno)
)
    comment '이벤트 첨부파일';

create table feed
(
    fno       int auto_increment comment '피드번호'
        primary key,
    mno       int                                     not null comment '회원번호',
    title     varchar(200)                            not null comment '제목',
    cont      mediumtext                              not null comment '내용',
    date      date        default current_timestamp() not null comment '작성일',
    thumbnail varchar(250)                            null comment '대표이미지',
    tname     varchar(20) default 'feed'              null,
    likecnt   int         default 0                   not null comment '좋아요수',
    pub       tinyint(1)  default 0                   not null comment '공개여부',
    constraint FK_member_TO_feed
        foreign key (mno) references testdb.member (mno)
)
    comment '피드';

    create table feed_like
(
    flno int auto_increment comment '좋아요번호'
        primary key,
    mno  int not null comment '회원번호',
    fno  int not null comment '피드번호',
    constraint FK_feed_TO_feed_like
        foreign key (fno) references testdb.feed (fno),
    constraint FK_member_TO_feed_like
        foreign key (mno) references testdb.member (mno)
)
    comment '좋아요';

create table feed_file
(
    feedfileno int auto_increment comment '첨부파일 번호'
        primary key,
    fno        int          not null comment '피드번호',
    filename   varchar(200) null comment '첨부파일명',
    path       varchar(200) not null comment '파일 경로',
    savename   varchar(200) null comment '저장파일명',
    constraint FK_feed_TO_feed_file
        foreign key (fno) references feed (fno)
)
    comment '피드 첨부파일';

create table feed_reply
(
    frno int auto_increment comment '댓글 번호'
        primary key,
    fno  int                  not null comment '피드번호',
    mno  int                  not null comment '회원번호',
    cont mediumtext           not null comment '내용',
    date date                 not null comment '작성일',
    pub  tinyint(1) default 0 not null comment '공개여부',
    constraint FK_feed_TO_feed_reply
        foreign key (fno) references feed (fno),
    constraint FK_member_TO_feed_reply
        foreign key (mno) references member (mno)
)
    comment '댓글';

create table follower
(
    follow    int not null comment '팔로우',
    following int not null comment '팔로잉',
    primary key (follow, following),
    constraint FK_member_TO_follower
        foreign key (follow) references member (mno),
    constraint FK_member_TO_follower2
        foreign key (following) references member (mno)
)
    comment '팔로잉/팔로우';

create table party
(
    pno        int auto_increment comment '파티원모집번호'
        primary key,
    mno        int                         not null comment '회원번호',
    meal       varchar(50)                 not null comment '모임시간대',
    food       varchar(200)                not null comment '음식종류',
    title      varchar(200)                not null comment '제목',
    cont       mediumtext                  not null comment '내용',
    gender     varchar(10)                 not null comment '성별',
    max        int                         not null comment '최대모집인원',
    time       datetime                    not null comment '시간',
    age        int                         not null comment '연령',
    lit        int                         not null comment '인원제한',
    loc        varchar(255)                not null comment '장소명',
    post       varchar(15)                 not null comment '장소우편번호',
    addr       varchar(255)                not null comment '장소주소',
    viewcnt    int                         null comment '조회수',
    pub        tinyint(1)  default 0       not null comment '공개여부',
    createdate datetime                    not null comment '게시글 작성 시간',
    thumbnail  varchar(255)                null comment '썸네일',
    date       date                        null,
    tname      varchar(20) default 'party' null,
    constraint FK_member_TO_party
        foreign key (mno) references member (mno)
)
    comment '파티원모집';

create table party_file
(
    pfileno  int auto_increment comment '첨부파일 번호'
        primary key,
    pno      int          not null comment '파티원모집번호',
    filename varchar(200) null comment '첨부파일명',
    path     varchar(200) not null comment '파일 경로',
    savename varchar(200) null comment '저장파일명',
    constraint FK_party_TO_party_file
        foreign key (pno) references party (pno)
)
    comment '파티게시판 첨부파일';

create table party_like
(
    mno int not null comment '회원번호'
        primary key,
    constraint FK_member_TO_party_like
        foreign key (mno) references member (mno)
)
    comment '파티원모집좋아요';

create table party_reply
(
    prno int auto_increment comment '댓글 번호'
        primary key,
    mno  int                  not null comment '회원번호',
    pno  int                  not null comment '파티원모집번호',
    cont mediumtext           null comment '내용',
    date date                 null comment '작성일',
    pub  tinyint(1) default 0 not null comment '공개여부',
    constraint FK_member_TO_party_reply
        foreign key (mno) references member (mno),
    constraint FK_party_TO_party_reply
        foreign key (pno) references party (pno)
)
    comment '댓글';

create table q_state
(
    qsno   int auto_increment comment '질문유형번호'
        primary key,
    qsname varchar(255) not null comment '질문유형명'
)
    comment '질문유형';

create table cs1
(
    cs1no      int auto_increment comment '문의번호'
        primary key,
    mno        int          not null comment '회원번호',
    qsno       int          not null comment '질문유형번호',
    title      varchar(200) not null comment '제목',
    cont       mediumtext   not null comment '내용',
    createdate date         not null comment '작성일',
    answer     mediumtext   null comment '답변',
    answerdate date         null comment '답변일',
    constraint FK_member_TO_cs1
        foreign key (mno) references member (mno),
    constraint FK_q_state_TO_cs1
        foreign key (qsno) references q_state (qsno)
)
    comment '고객센터 1:1문의';

create table cs1_file
(
    cs1fileno int auto_increment comment '첨부파일 번호'
        primary key,
    cs1no     int          not null comment '문의번호',
    filename  varchar(200) null comment '첨부파일명',
    path      varchar(200) not null comment '파일 경로',
    savename  varchar(200) null comment '저장파일명',
    constraint FK_cs1_TO_cs1_file
        foreign key (cs1no) references cs1 (cs1no)
)
    comment '고객센터 첨부파일';

create table qna
(
    qno    int        not null comment '질문번호'
        primary key,
    cont   mediumtext not null comment '질문내용',
    answer mediumtext not null comment '답변내용'
)
    comment '자주묻는질문';

create table report
(
    rno     int auto_increment comment '신고번호',
    repoter int        not null comment '고발자',
    acsd    int        not null comment '피고발자',
    reason  mediumtext not null comment '신고사유',
    rcnt    int        not null comment '상태',
    primary key (rno, repoter, acsd),
    constraint FK_member_TO_report
        foreign key (repoter) references member (mno),
    constraint FK_member_TO_report2
        foreign key (acsd) references member (mno)
)
    comment '신고';

create table tag
(
    tno int auto_increment comment '태그번호'
        primary key,
    tag varchar(50) not null comment '태그명'
)
    comment '태그';

create table partytag
(
    pno int not null comment '파티원모집번호',
    tno int not null comment '태그번호',
    primary key (pno, tno),
    constraint FK_party_TO_partytag
        foreign key (pno) references party (pno),
    constraint FK_tag_TO_partytag
        foreign key (tno) references tag (tno)
)
    comment '파티원모집태그';

create table ticket
(
    tno     int auto_increment comment '입장권구매번호'
        primary key,
    mno     int                  not null comment '회원번호',
    eno     int                  not null comment '게시글 번호',
    pay     varchar(30)          not null comment '결제수단',
    paydate datetime             not null comment '결제일',
    paycnt  int                  not null comment '결제수량',
    cancel  tinyint(1) default 0 not null comment '결제취소',
    constraint FK_event_TO_ticket
        foreign key (eno) references event (eno),
    constraint FK_member_TO_ticket
        foreign key (mno) references member (mno)
)
    comment '입장권구매';

create table review
(
    tno   int auto_increment comment '입장권구매번호'
        primary key,
    title varchar(200) null comment '제목',
    cont  mediumtext   null comment '내용',
    date  date         null comment '등록일',
    constraint FK_ticket_TO_review
        foreign key (tno) references ticket (tno)
)
    comment '리뷰';

create table rv_file
(
    rwfileno int auto_increment comment '리뷰이미지번호'
        primary key,
    tno      int          not null comment '입장권구매번호',
    filename varchar(200) null comment '첨부파일명',
    path     varchar(200) not null comment '파일경로',
    savename varchar(200) null comment '저장파일명',
    constraint FK_review_TO_rv_file
        foreign key (tno) references review (tno)
)
    comment '리뷰이미지';

create table volunteer
(
    vno   int                  not null comment '파티원모집번호',
    mno   int                  not null comment '회원번호',
    date  date                 not null comment '참여신청일',
    state tinyint(1) default 0 null comment '상태(참여여부 참:0 미참:1)',
    etc   mediumtext           null comment '비고(거절사유)',
    primary key (vno, mno),
    constraint FK_member_TO_volunteer
        foreign key (mno) references member (mno),
    constraint FK_party_TO_volunteer
        foreign key (vno) references party (pno)
)
    comment '참여자';

