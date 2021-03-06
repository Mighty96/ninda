# 닌다 (Ninda)

__목차__

1. 웹 서비스 소개
2. 기술 스택
3. 주요 기능


# 1. 웹 서비스 소개

> https://ninda.kr

![01](https://user-images.githubusercontent.com/68958979/134797130-be26ed51-3b7a-479d-afdf-ab78ab093b26.png)

`닌다`는 게임사 닌텐도의 신작등을 소개하는 인터넷 프레젠테이션 방송 `닌텐도 다이렉트`를 줄인 말입니다.  
가격, 발매예정, 설명, 할인소식 등 닌텐도 게임의 여러 정보를 취합하여 유저에게 제공하고, 더 나아가서는 유저들의 커뮤니티를 형성하고자 하는 의도로 제작되었습니다.

# 2. 기술 스택

`Front-end`

- Thymeleaf / Thymeleaf-layout-dialect / Thymeleaf-extras-springsecurity5
- jquery 3.6.0
- Bootstrap 4.6.0

`Back-end`

- JAVA 11
- SpringBoot 2.5.0
  - Spring Data JPA
  - Spring Mail
  - Spring Security
- Lombok
- javax.mail
- jsoup
- Maria DB
- h2 (For local)

`Deploy`

- AWS EC2
- AWS S3
- AWS Code Deploy
- AWS RDS
- AWS Route53
- Travis CI
- Nginx


# 3. 사용자 주요기능

## 메인화면

![02](https://user-images.githubusercontent.com/68958979/134797884-ec19d7f8-c78c-4ae4-9909-0eb3f071f05c.png)

- 당일 기준으로 가장 `최신 발매작` 게임 5개를 사진과 함께 소개합니다.
- `최근 작성된 한줄평`, `자유게시판`, `멀티-내전게시판` 세 문단으로 나누어 최신 글을 확인할 수 있으며, 상호작용시 해당 게시글(한줄평)으로 이동합니다.
- Hot 타이틀 Top 10을 표시합니다.
  - Hot 타이틀은 24시간 이내에 사람들이 가장 많이 접근한 게임을 내림차순으로 정렬하여 선정합니다.
- 일본 닌텐도 트위터를 통해 최신정보들을 빠르게 확인할 수 있습니다.

## 게임 리스트

![03](https://user-images.githubusercontent.com/68958979/134797910-b12803c4-ba6f-49fe-96e7-90e09fdac344.png)

- 현재 한국닌텐도에 정식으로 등록된 게임들을 보여줍니다.
- 사용자의 기호에 따라 `이름순` / `최신순` / `인기순(조회수)` / `추천순(추천)` 중 정렬방식을 선택할 수 있습니다.
  - 모든 정렬방식은 `이름순`을 포함합니다.
  - 아직 출시되지 않은 게임을 제외하거나, 할인 중인 타이틀만을 조회할 수 있습니다.
- 현재 할인 중인 타이틀의 경우 별도로 `Sale!!`스티커를 표시합니다.
- 검색 기능을 제공합니다.
- 페이징을 통해 조건에 부합하는 게임을 12개씩 끊어 표현합니다.

## 게임 상세페이지

![04](https://user-images.githubusercontent.com/68958979/134798017-90f8de03-b1be-4af6-acd9-f81f117d4e76.png)

- 게임의 타이틀, 발매일, 가격, 소개 등 게임에 대한 정보를 보여줍니다.
  - 현재 할인 중인 게임의 경우 `할인기간` 및 `할인가`를 보여줍니다.
- `추천 및 비추천` 기능이 적용되어 있습니다.
  - 로그인 한 사용자만 사용할 수 있습니다.
- 게임에 대한 `한줄평`을 남길 수 있습니다.
  - 남겨진 한줄평의 수를 표기합니다.
  - 본인의 한줄평에 대해 수정 및 삭제가 가능합니다.
  - `추천 및 비추천` 기능이 적용되어 있습니다.
  - 로그인 한 사용자만 사용할 수 있습니다.

## 닌텐도 다이렉트

![05](https://user-images.githubusercontent.com/68958979/134798141-8da1a26d-ae31-46fd-bab0-f00f8f312f4e.png)

- 인터넷 프레젠테이션 방송 `닌텐도 다이렉트` 유튜브 영상을 제공하고, 유저들이 소통할 수 있는 공간입니다.
- 조회수 중복 방지 기능이 적용되어 있습니다.
- 유튜브 영상의 경우 `영어 음성 + 한글자막`, `일본`, `영어` 세 가지 방식으로 제공됩니다. 사용자가 임의로 선택하여 시청할 수 있습니다.
  - 만약 해당 탭의 영상이 존재하지 않는다면 비활성화됩니다.
- `추천 및 비추천` 기능이 적용되어 있습니다.
  - 로그인 한 사용자만 사용할 수 있습니다.
- 닌텐도 다이렉트에 대한 `소감`을 남길 수 있습니다.
  - 남겨진 소감의 수를 표기합니다.
  - 본인의 소감에 대해 수정 및 삭제가 가능합니다.
  - `추천 및 비추천` 기능이 적용되어 있습니다.
  - 로그인 한 사용자만 사용할 수 있습니다.

## 게시판

![06](https://user-images.githubusercontent.com/68958979/134798278-d3f3abcc-927b-452b-a81b-1929ecc28977.png)

- `자유게시판`, `멀티-내전게시판`, `친구코드 공유 게시판` 등 여러가지 목적의 게시판이 존재합니다.
- 게시글은 최신순으로 정렬됩니다.
- 조회수 중복 방지 기능이 적용되어 있습니다.
- 로그인 한 사용자는 게시글을 등록할 수 있습니다.
- 자유게시판에서 일간 베스트 Top 5, 주간 베스트 Top 5, 월간 베스트 Top 5 게시글을 확인할 수 있습니다. 추천순을 기준으로 정렬됩니다.
- 게시글이 관리자가 설정한 특정 수 이상의 추천을 받았을 경우 제목에 `추천글`아이콘이 붙습니다.
- `추천글`만을 모아서 볼 수 있습니다.
- 검색기능을 제공합니다. `제목+내용`, `제목`, `내용`, `글쓴이` 네가지 항목에 대하여 검색할 수 있습니다.
- 페이징 기능을 제공합니다.

## 게시글

![07](https://user-images.githubusercontent.com/68958979/134798437-634b52a1-abc0-4478-a7ec-6ddfd078128a.png)

- 게시글의 상세 내용을 보여줍니다.
- 본인의 게시글에 대해 수정 및 삭제가 가능합니다.
- `추천 및 비추천` 기능이 적용되어 있습니다.
  - 로그인 한 사용자만 사용할 수 있습니다.
- 게시글에 대한 `댓글`을 남길 수 있습니다.
  - 남겨진 댓글의 수를 표기합니다.
  - 본인의 댓글에 대해 수정 및 삭제가 가능합니다.
  - `추천 및 비추천` 기능이 적용되어 있습니다.
  - 로그인 한 사용자만 사용할 수 있습니다.
  - `대댓글`기능을 제공합니다.
    - 댓글을 클릭하면 대댓글을 작성할 수 있으며, 등록시 모 댓글의 타래 형태로 들여쓰기되어 등록됩니다.
- 게시글의 하단에서도 해당 페이지의 다른 게시글들을 쉽게 확인할 수 있습니다.

## 마이페이지

![08](https://user-images.githubusercontent.com/68958979/134798572-6e037048-a734-4613-a14c-f1d8ff2c7c8a.png)

- 내 정보를 확인할 수 있습니다.
  - 닉네임을 변경하거나, 자기소개를 작성할 수 있습니다.
  - 가입일을 확인할 수 있습니다.
- 비밀번호를 변경할 수 있습니다.



- 내가 작성한 글을 확인할 수 있습니다.
  - 전체 게시판을 일괄 조회하거나, 특정 게시판만을 선택하여 조회할 수 있습니다.
  
![09](https://user-images.githubusercontent.com/68958979/134798590-23874e50-e7de-4982-a218-4f72da67d72c.png)

- 내가 작성한 한줄평을 확인할 수 있습니다.
- 내가 관심있어 하는 게임을 확인할 수 있습니다. (미구현)