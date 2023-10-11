# Springboot-Redis Cache 사용하는 법을 기록한 레포지토리

## 목적

- Springboot에서 redis를 연동, **`Cache Annotation`** 을 이용해서 실제로 Cache가 되는지 확인
- 간단한 테스트를 통해 어떻게 설정했는지, 어떻게 적용되었는지 기록합니다.

## 환경
- JPA(MariaDB) 사용, **캐시가 되었는지만 확인할 Board Entity**만 생성
- springboot 3.1.4
- redis 7.0.12 (docker 이용)

## 발전 방향
- RedisTemplate, RedisRepository에 대해서 학습해둔 프로젝트를 추후 기록하겠습니다.

## 각 코드가 적혀있는 부분에 README를 남겨둡니다.
- MainRedisConfig
- TestService
