# 코드와 같이 보시면 됩니다.

## @EnableCaching

- 해당 어노테이션을 붙여줌으로써 캐싱 기능을 활성화
- 이제 DB에서 데이터를 읽어오는 부분이 필요할 때, @Cacheable 등의 어노테이션 등을 이용해 캐싱 기능을 이용할 수 있음.

### public RedisConnectionFactory redisConnectionFactory()

- Springboot 2.0 이상은 **기본적으로 Lettuce를 사용**
- 생략해도 무방하나, 명확하게 의미를 알려주기 위해 사용합니다.
    - LettuceConnectionFactory
- 생성한 LettuceConnectionFactory에서 사용할 Redis의 HOST, PORT, PW를 설정
    - **PW는 테스트 환경이므로 생략했으나, 반드시 설정해 주는게 좋습니다.**

### public RedisTemplate

<aside>
💡 추후 업데이트를 위해 선언해둔 것, 나중에 내용 추가하겠습니다.

</aside>

### public CacheManager cacheManager()

- mainRedisFactory에서 생성한 connectionFactory를 주입해줍니다.
- Value Serialize를 객체로 하기 때문에, **`GenericJackson2JsonRedisSerializer`**를 사용합니다.
    - ObjectMapper를 안에 **추가로 선언하고 안하고의 차이가 존재**합니다.
- entryTtl에 Cache를 유지할 시간을 설정합니다.


### GenericJackson2JsonRedisSerializer

- ObjectMapper를 선언하여 생성자의 변수로 넣어주지 않을 경우, class 타입까지 같이 저장됩니다. MSA 환경이라면, 모든 패키지나 클래스를 똑같이 해주지 않는 이상 실패하는 지점이 분명 발생합니다.
- 선언하지 않았을 경우,
    
    ```json
    "java.util.ArrayList",
    [{"@class":"com.example.redis.test.domain.Board","id":12,"userId":"강병선","userName":"1"},
    {"@class":"com.example.redis.test.domain.Board","id":13,"userId":"강병선","userName":"12"}
    ```
    
- ObjectMapper를 선언해줬을 경우
    
    ```json
    [{"id":12,"userId":"강병선","userName":"1"},
    {"id":13,"userId":"강병선","userName":"12"}
    ```
    
- 선언해주는 것이 더 관리가 용이하다고 판단하여 선언해주었습니다.
- 그러나 **LinkedHashMap** 타입 관한 에러가 날 수 있기 때문에 조금 더 디테일하게 공부하고 수정하겠습니다.
- **GenericJackson2JsonRedisSerializer의 생성자 형식을 참고하시면 도움이 됩니다.**
