# 어노테이션 설명

- @EnableCaching
    - 캐시 기능을 사용하기 위해 선언해줍니다.
- `@Cacheable`
    - **자주 변하지 않고, 많은 조회가 필요한 곳에 캐싱 처리는 적합합니다.**
    
    ```java
    @Cacheable(value="boardList",key="#id")
        public List<Board> getAll(String id) {
            return testRepository.findAllByUserId(id);
        }
    ```
    
    - 캐시에 데이터가 없을 경우 testRepository를 실행해서 캐시에 데이터를 추가
    - 캐시에 데이터가 있다면 그대로 반환
    - 최초 호출 시는 testRepository를 호출하여 값을 넣어줄 것이고
    - 그 이후에는 Cache에 있다면 찾아낼 것입니다.
    - 여기서 key값은 id이고, value는 boardList인데 redis-cli에서 명령어로 확인 가능합니다.
        - GET boardList::id
          ![image](https://github.com/ssjjaa-algo/springboot-redis/assets/57981401/42a9faa6-2efc-480c-97ae-eb604d854bb0)


- `@CacheEvict`
    - 캐시의 제거를 위해 사용
        - 값의 변화가 생긴다면 기존 캐시를 제거해줘야 할 때, 사용할 수 있습니다.
    - 메서드의 키에 해당하는 캐시를 제거합니다.
    
    ```java
    @CacheEvict(value="boardList",key="#id")
        public void regist(Board board, String id) {
            testRepository.save(board);
    
        }
    ```
    

- `@CachePut`
    - 캐시에 값을 저장하는 용도로만 사용합니다.
    - **항상 메서드의 로직을 실행합니다.**
        - 이를 통해 DB와의 일관성을 유지할 수 있습니다.
