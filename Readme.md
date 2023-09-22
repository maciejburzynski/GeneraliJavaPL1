# Security
## User
1. Adding `spring-boot-starter-security` dependency in your `pom.xml` file with no code changes provides changes:
   - Access to our app is restricted. We will be redirected to `login`. Default credentials:
   - Username: `user` Password: `<To be provided during startup in Logs>`


2. We can override default `User` credentials by modifying configuration file (`application.properties`/`application.yml`) by adding following properties:
   - `spring.security.user.name=<username>` `spring.security.user.password=<password>`


3. InMemoryUser added to Security config class:
   - Sping-Boot 3.x - please follow [Documentation](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html)
   - Sping-Boot 2.x - please follow [Documentation](https://www.geeksforgeeks.org/spring-security-in-memory-authentication/)

## Management Rights/Privileges

1. Spring-Boot 3.x
   - `@Bean` method in Security config class 
```console
@Bean
public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
   httpSecurity.authorizeHttpRequests(request -> request
               .requestMatchers(AntPathRequestMatcher.antMatcher("/api/**")).hasAnyRole("USER", "ADMIN")
               .anyRequest().permitAll());
```
   - Adding this Bean may impact on Basic Auth behaviour (e.g.Form login). To return to default we need to add basic auth and form login code
```console
@Bean
public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
   httpSecurity.authorizeHttpRequests(request -> request
               .requestMatchers(AntPathRequestMatcher.antMatcher("/api/**")).hasAnyRole("USER", "ADMIN")
               .anyRequest().permitAll());


   httpSecurity.httpBasic(Customizer.withDefaults()); 
   httpSecurity.formLogin(Customizer.withDefaults());
```