기술 소개서

👍팀명 : 1석2조

프로젝트 : BookVoyage

💻설치 순서 :

1-1) STS4 설치

1-2) STS4 실행 - 파일 - import - Existing gradle project 선택 - import할 프로젝트 디렉토리 선택 -
	Override workspace settings 선택 후 Specific Gradle Version 7.5.1 입력 - finish

1-3) Package Explorer - frontend 우클릭 - show in local terminal - terminal 선택 - npm install 입력 - node_modules 설치

1-4) SecretKey.java, application-secret.properties 는 민감 정보가 포함되어 있어 필요 시 별도 제공

2-1) MySQL 8.0 설치

2-2) 도서 데이터는 sql 파일 별도 import 필요
 - MySQL 실행 - root 계정 접속 - Navigator 하단 Administration 선택 - MANAGEMENT - Data Import - Import from Self-Contained File -
별도 제공하는 book.sql import

📰application.properties

server.port=9090

#spring.main.allow-bean-definition-overriding = true
#spring.main.allow-circular-references = true

spring.profiles.active=secret

spring.jpa.open-in-view = true
spring.jpa.hibernate.ddl-auto=update	// 처음 서버 실행 시 create로 한 뒤 테이블 생성 후 update로 변경해야 함
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

spring.mail.default-encoding=EUC-KR
spring.mail.port=587

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.starttls.enable=true

💿실행 순서
1) STS4 실행
2) application.properties - spring.jpa.hibernate.ddl-auto=create로 변경
3) BookVoyage 프로젝트 우클릭 - Run as - Spring boot application 클릭
4) 서버 중단 후 MySQL 실행하여 book.sql import
5) application.properties - spring.jpa.hibernate.ddl-auto=update로 변경
6) 서버 재실행
7) Package Explorer - frontend 우클릭 - show in local terminal - terminal - npm start
8) 크롬 자동 실행


🧾프로젝트 구조

백엔드(스프링부트)
java
 ┗ 📂com
 ┃ ┗ 📂kdt
 ┃ ┃ ┗ 📂BookVoyage
 ┃ ┃ ┃ ┣ 📂Admin
 ┃ ┃ ┃ ┃ ┣ 📜AdminController.java
 ┃ ┃ ┃ ┃ ┣ 📜AdminDTO.java
 ┃ ┃ ┃ ┃ ┣ 📜AdminRepository.java
 ┃ ┃ ┃ ┃ ┗ 📜AdminService.java
 ┃ ┃ ┃ ┣ 📂Board
 ┃ ┃ ┃ ┃ ┣ 📜BaseEntity.java
 ┃ ┃ ┃ ┃ ┣ 📜BoardController.java
 ┃ ┃ ┃ ┃ ┣ 📜BoardDeleteDTO.java
 ┃ ┃ ┃ ┃ ┣ 📜BoardDTO.java
 ┃ ┃ ┃ ┃ ┣ 📜BoardEntity.java
 ┃ ┃ ┃ ┃ ┣ 📜BoardRepository.java
 ┃ ┃ ┃ ┃ ┣ 📜BoardService.java
 ┃ ┃ ┃ ┃ ┣ 📜NotFoundException.java
 ┃ ┃ ┃ ┃ ┗ 📜WrapperClass.java
 ┃ ┃ ┃ ┣ 📂Book
 ┃ ┃ ┃ ┃ ┣ 📜AdminBookSearchRes.java
 ┃ ┃ ┃ ┃ ┣ 📜AladinBookDetailReq.java
 ┃ ┃ ┃ ┃ ┣ 📜AladinBookDetailRes.java
 ┃ ┃ ┃ ┃ ┣ 📜AladinBookSearchReq.java
 ┃ ┃ ┃ ┃ ┣ 📜AladinBookSearchRes.java
 ┃ ┃ ┃ ┃ ┣ 📜AladinItemListReq.java
 ┃ ┃ ┃ ┃ ┣ 📜AladinItemListRes.java
 ┃ ┃ ┃ ┃ ┣ 📜BookController.java
 ┃ ┃ ┃ ┃ ┣ 📜BookDto.java
 ┃ ┃ ┃ ┃ ┣ 📜BookEntity.java
 ┃ ┃ ┃ ┃ ┣ 📜BookRepository.java
 ┃ ┃ ┃ ┃ ┣ 📜BookService.java
 ┃ ┃ ┃ ┃ ┣ 📜DuplicateBookException.java
 ┃ ┃ ┃ ┃ ┣ 📜InvalidIsbnException.java
 ┃ ┃ ┃ ┃ ┗ 📜RestTemplateConfig.java
 ┃ ┃ ┃ ┣ 📂Cart
 ┃ ┃ ┃ ┃ ┣ 📜CartController.java
 ┃ ┃ ┃ ┃ ┣ 📜CartDto.java
 ┃ ┃ ┃ ┃ ┣ 📜CartEntity.java
 ┃ ┃ ┃ ┃ ┣ 📜CartRepository.java
 ┃ ┃ ┃ ┃ ┣ 📜CartRequest.java
 ┃ ┃ ┃ ┃ ┗ 📜CartService.java
 ┃ ┃ ┃ ┣ 📂CartItem
 ┃ ┃ ┃ ┃ ┣ 📜CartItemDto.java
 ┃ ┃ ┃ ┃ ┣ 📜CartItemEntity.java
 ┃ ┃ ┃ ┃ ┗ 📜CartItemRepository.java
 ┃ ┃ ┃ ┣ 📂Common
 ┃ ┃ ┃ ┃ ┣ 📜AsyncConfig.java
 ┃ ┃ ┃ ┃ ┣ 📜CookieConfig.java
 ┃ ┃ ┃ ┃ ┣ 📜DuplicatedIdException.java
 ┃ ┃ ┃ ┃ ┣ 📜ExpiredViewTimeException.java
 ┃ ┃ ┃ ┃ ┣ 📜InvalidIsbn13Exception.java
 ┃ ┃ ┃ ┃ ┣ 📜OrderNotFoundException.java
 ┃ ┃ ┃ ┃ ┣ 📜OrderProductNotFoundException.java
 ┃ ┃ ┃ ┃ ┣ 📜ProductIsNotExistException.java
 ┃ ┃ ┃ ┃ ┣ 📜ReactWebController.java
 ┃ ┃ ┃ ┃ ┣ 📜TimeBaseEntity.java
 ┃ ┃ ┃ ┃ ┣ 📜TokenNotValidateException.java
 ┃ ┃ ┃ ┃ ┣ 📜TokenRegenerationFailException.java
 ┃ ┃ ┃ ┃ ┣ 📜UnauthorizedAccessException.java
 ┃ ┃ ┃ ┃ ┣ 📜UserIdNotFoundException.java
 ┃ ┃ ┃ ┃ ┗ 📜UserPasswordNotMatchException.java
 ┃ ┃ ┃ ┣ 📂EmailVerification
 ┃ ┃ ┃ ┃ ┣ 📜EmailController.java
 ┃ ┃ ┃ ┃ ┣ 📜EmailDTO.java
 ┃ ┃ ┃ ┃ ┣ 📜EmailEntity.java
 ┃ ┃ ┃ ┃ ┣ 📜EmailHtml.java
 ┃ ┃ ┃ ┃ ┣ 📜EmailRepository.java
 ┃ ┃ ┃ ┃ ┗ 📜EmailService.java
 ┃ ┃ ┃ ┣ 📂Member
 ┃ ┃ ┃ ┃ ┣ 📜MemberController.java
 ┃ ┃ ┃ ┃ ┣ 📜MemberDTO.java
 ┃ ┃ ┃ ┃ ┣ 📜MemberEntity.java
 ┃ ┃ ┃ ┃ ┣ 📜MemberRepository.java
 ┃ ┃ ┃ ┃ ┣ 📜MemberRole.java
 ┃ ┃ ┃ ┃ ┣ 📜MemberService.java
 ┃ ┃ ┃ ┃ ┗ 📜MemberServiceImpl.java
 ┃ ┃ ┃ ┣ 📂Order
 ┃ ┃ ┃ ┃ ┣ 📜OrderDetailDTO.java
 ┃ ┃ ┃ ┃ ┣ 📜OrderDTO.java
 ┃ ┃ ┃ ┃ ┣ 📜OrderEntity.java
 ┃ ┃ ┃ ┃ ┣ 📜OrderProductDTO.java
 ┃ ┃ ┃ ┃ ┣ 📜OrderProductEntity.java
 ┃ ┃ ┃ ┃ ┣ 📜OrderProductRepository.java
 ┃ ┃ ┃ ┃ ┗ 📜OrderRepository.java
 ┃ ┃ ┃ ┣ 📂Purchase
 ┃ ┃ ┃ ┃ ┣ 📜PurchaseController.java
 ┃ ┃ ┃ ┃ ┣ 📜PurchaseDTO.java
 ┃ ┃ ┃ ┃ ┗ 📜PurchaseService.java
 ┃ ┃ ┃ ┣ 📂Reply
 ┃ ┃ ┃ ┃ ┣ 📜ReplyController.java
 ┃ ┃ ┃ ┃ ┣ 📜ReplyDTO.java
 ┃ ┃ ┃ ┃ ┣ 📜ReplyEntity.java
 ┃ ┃ ┃ ┃ ┣ 📜ReplyRepository.java
 ┃ ┃ ┃ ┃ ┗ 📜ReplyService.java
 ┃ ┃ ┃ ┣ 📂Security
 ┃ ┃ ┃ ┃ ┣ 📜JwtFilter.java
 ┃ ┃ ┃ ┃ ┣ 📜SecretKey.java
 ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.java
 ┃ ┃ ┃ ┃ ┣ 📜TokenConfig.java
 ┃ ┃ ┃ ┃ ┣ 📜TokenDecoder.java
 ┃ ┃ ┃ ┃ ┗ 📜TokenDTO.java
 ┃ ┃ ┃ ┗ 📜BookVoyageApplication.java


프론트엔드(리액트)
📦src
 ┣ 📂common
 ┃ ┣ 📜Button.js
 ┃ ┣ 📜CategoryHeader.js
 ┃ ┣ 📜Footer.js
 ┃ ┗ 📜Header.js
 ┣ 📂component
 ┃ ┣ 📂BOARD
 ┃ ┃ ┣ 📜EditorComponent.js
 ┃ ┃ ┣ 📜QnA_BoardBox.js
 ┃ ┃ ┣ 📜QnA_BoardList.js
 ┃ ┃ ┣ 📜QnA_BoardPagination.js
 ┃ ┃ ┗ 📜QnA_Reply.js
 ┃ ┣ 📂Book
 ┃ ┃ ┣ 📂BookDetail
 ┃ ┃ ┃ ┗ 📜BookDetail.js
 ┃ ┃ ┣ 📂BookList
 ┃ ┃ ┃ ┗ 📜AllBookList.js
 ┃ ┃ ┣ 📂Cart
 ┃ ┃ ┃ ┗ 📜Cart.js
 ┃ ┃ ┣ 📂FilteredBookList
 ┃ ┃ ┃ ┗ 📜FilteredBookList.js
 ┃ ┃ ┣ 📂Home
 ┃ ┃ ┃ ┣ 📜BestSeller.js
 ┃ ┃ ┃ ┣ 📜EconomyBooks.js
 ┃ ┃ ┃ ┣ 📜Home.js
 ┃ ┃ ┃ ┣ 📜NewBook.js
 ┃ ┃ ┃ ┣ 📜Novel.js
 ┃ ┃ ┃ ┣ 📜ScienceBooks.js
 ┃ ┃ ┃ ┗ 📜SelfDevelopment.js
 ┃ ┃ ┣ 📂Regist
 ┃ ┃ ┃ ┣ 📜BookRegist.js
 ┃ ┃ ┃ ┗ 📜BookSearch.js
 ┃ ┃ ┗ 📂SearchBook
 ┃ ┃ ┃ ┗ 📜SearchBook.js
 ┃ ┗ 📜Test.js
 ┣ 📂css
 ┃ ┣ 📂ADMIN
 ┃ ┃ ┣ 📜adminLogin.module.css
 ┃ ┃ ┣ 📜adminManage.module.css
 ┃ ┃ ┣ 📜orderManage.module.css
 ┃ ┃ ┣ 📜orderManageDetail.module.css
 ┃ ┃ ┣ 📜productManage.module.css
 ┃ ┃ ┣ 📜registerBook.module.css
 ┃ ┃ ┗ 📜userManage.module.css
 ┃ ┣ 📂BOARD
 ┃ ┃ ┣ 📜board.css
 ┃ ┃ ┣ 📜board.module.css
 ┃ ┃ ┗ 📜reply.module.css
 ┃ ┣ 📂CartPage
 ┃ ┃ ┗ 📜Cart.module.css
 ┃ ┣ 📂Common
 ┃ ┃ ┣ 📜categoryHeader.module.css
 ┃ ┃ ┣ 📜footer.module.css
 ┃ ┃ ┣ 📜header.module.css
 ┃ ┃ ┣ 📜jw_topBtn.module.css
 ┃ ┃ ┗ 📜Loading.module.css
 ┃ ┣ 📂DetailPage
 ┃ ┃ ┗ 📜BookDetail.css
 ┃ ┣ 📂ListPage
 ┃ ┃ ┗ 📜AllBookList.css
 ┃ ┣ 📂LogInPage
 ┃ ┃ ┗ 📜logInPage.module.css
 ┃ ┣ 📂MainPage
 ┃ ┃ ┣ 📜BookList.module.css
 ┃ ┃ ┗ 📜Main.module.css
 ┃ ┣ 📂MyPage
 ┃ ┃ ┣ 📜findMyIdPage.module.css
 ┃ ┃ ┣ 📜findMyPwPage.module.css
 ┃ ┃ ┣ 📜modifyPasswordPage.module.css
 ┃ ┃ ┣ 📜myPage.module.css
 ┃ ┃ ┣ 📜myPageAndModifyPaswordPage.module.css
 ┃ ┃ ┣ 📜myPageAuth.module.css
 ┃ ┃ ┣ 📜orderDetail.module.css
 ┃ ┃ ┗ 📜orderListPage.module.css
 ┃ ┣ 📂PurchasePage
 ┃ ┃ ┣ 📜payment.module.css
 ┃ ┃ ┣ 📜purchasePage.module.css
 ┃ ┃ ┗ 📜purchseResultPage.module.css
 ┃ ┣ 📂SearchPage
 ┃ ┃ ┗ 📜SearchResults.css
 ┃ ┗ 📂SignUpPage
 ┃ ┃ ┗ 📜signUpPage.module.css
 ┣ 📂fonts
 ┃ ┣ 📜KakaoBold.ttf
 ┃ ┣ 📜KakaoOTFBold.otf
 ┃ ┣ 📜KakaoOTFRegular.otf
 ┃ ┣ 📜KakaoRegular.ttf
 ┃ ┣ 📜NanumSquareB.ttf
 ┃ ┣ 📜NanumSquareEB.ttf
 ┃ ┣ 📜NanumSquareL.ttf
 ┃ ┗ 📜NanumSquareR.ttf
 ┣ 📂hooks
 ┃ ┗ 📜useDebounce.js
 ┣ 📂js
 ┃ ┣ 📜AdminPageControl.js
 ┃ ┣ 📜combineReducers.js
 ┃ ┣ 📜convertToWon.js
 ┃ ┣ 📜getUserNumber.js
 ┃ ┣ 📜goToPurchase.js
 ┃ ┣ 📜HomeAddress.js
 ┃ ┣ 📜jw_topBtn.js
 ┃ ┣ 📜Loading.js
 ┃ ┣ 📜NotFound.js
 ┃ ┣ 📜Payment.js
 ┃ ┣ 📜ScrollTop.js
 ┃ ┣ 📜ThemeReducer.js
 ┃ ┣ 📜ThemeToggleBtn.js
 ┃ ┗ 📜unixToDate.js
 ┣ 📂lib
 ┃ ┗ 📂styles
 ┃ ┃ ┗ 📜palette.js
 ┣ 📂pages
 ┃ ┣ 📂AdminPage
 ┃ ┃ ┣ 📜AdminLogin.js
 ┃ ┃ ┣ 📜AdminMain.js
 ┃ ┃ ┣ 📜AdminTheme.js
 ┃ ┃ ┣ 📜OrderManage.js
 ┃ ┃ ┣ 📜OrderManageDetail.js
 ┃ ┃ ┣ 📜ProductManage.js
 ┃ ┃ ┣ 📜RegisterBook.js
 ┃ ┃ ┣ 📜UserChart.js
 ┃ ┃ ┗ 📜UserManage.js
 ┃ ┣ 📂BoardPage
 ┃ ┃ ┣ 📜QnA_CreateBoard.js
 ┃ ┃ ┣ 📜QnA_DetailBoard.js
 ┃ ┃ ┣ 📜QnA_Page.js
 ┃ ┃ ┗ 📜QnA_UpdateBoard.js
 ┃ ┣ 📂BookRegistPage
 ┃ ┃ ┗ 📜index.js
 ┃ ┣ 📂CartPage
 ┃ ┃ ┗ 📜index.js
 ┃ ┣ 📂DetailPage
 ┃ ┃ ┗ 📜index.js
 ┃ ┣ 📂FilteredBookPage
 ┃ ┃ ┗ 📜index.js
 ┃ ┣ 📂ListPage
 ┃ ┃ ┗ 📜index.js
 ┃ ┣ 📂LogInPage
 ┃ ┃ ┗ 📜LogInPage.js
 ┃ ┣ 📂MainPage
 ┃ ┃ ┗ 📜index.js
 ┃ ┣ 📂MyPage
 ┃ ┃ ┣ 📜FindMyIdPage.js
 ┃ ┃ ┣ 📜FindMyPwPage.js
 ┃ ┃ ┣ 📜ModifyPasswordPage.js
 ┃ ┃ ┣ 📜MyPage.js
 ┃ ┃ ┣ 📜MyPageAndModifyPasswordPage.js
 ┃ ┃ ┣ 📜MyPageAuth.js
 ┃ ┃ ┣ 📜OrderDetailPage.js
 ┃ ┃ ┗ 📜OrderListPage.js
 ┃ ┣ 📂PurchasePage
 ┃ ┃ ┣ 📜PruchaseResultPage.js
 ┃ ┃ ┗ 📜PurchasePage.js
 ┃ ┣ 📂SearchPage
 ┃ ┃ ┗ 📜index.js
 ┃ ┗ 📂SignUpPage
 ┃ ┃ ┗ 📜SignUpPage.js
 ┣ 📜App.js
 ┣ 📜AppAdmin.js
 ┣ 📜Apps.js
 ┣ 📜index.js
 ┗ 📜setupProxy.js