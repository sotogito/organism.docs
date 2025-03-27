| 메서드 | 반환 타입 | 설명 |
| --- | --- | --- |
| `selectOne` | 단일 객체 (`T`) | 결과가 **1행일 때 사용**※ 결과가 2행 이상이면 **예외 발생 (`TooManyResultsException`)** |
| `selectList` | `List<T>` | 결과가 **0행 이상일 때 사용**,**여러 행**을 리스트로 반환 |
| `selectMap` | `Map<K, V>` | 결과를 특정 컬럼을 key로 하는 **Map 형태로 반환** |
| `selectCursor` | `Cursor<T>` | **대용량 스트리밍 처리** 시 사용 (MyBatis 3.5+) |

---
| 메서드 | 결과 수 | 결과 타입 | 예외 발생 조건 |
| --- | --- | --- | --- |
| `selectOne` | 0 또는 1 | 단일 객체 or null | 결과 2개 이상일 때 예외 |
| `selectList` | 0 이상 | `List<T>` | ❌ 없음 |
| `selectMap` | 0 이상 | `Map<K, V>` | ❌ 없음 |
| `selectCursor` | 0 이상 | `Cursor<T>` | ❌ 없음 |
