import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    stages: [
      { duration: '30s', target: 0 },
      { duration: '1m', target: 100 },
      { duration: '30s', target: 0 },
    ],
    thresholds: {
        http_req_failed: ['rate<0.01'], // http errors should be less than 1%
        http_req_duration: ['p(95)<2000'], // 95% of requests should be below 2000ms
      },
  };
  

  export default function () {
    const res = http.get('https://reqres.in/api/users?page=2');
    check(res, { 'status was 200': (r) => r.status == 200 });
    sleep(1);
  }