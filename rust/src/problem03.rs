pub fn solve() {
    let n: u64 = 600851475143;
    let factors = prime_factors(&n);
    let result: Option<&u64> = factors.iter().max();

    println!("{}", result.unwrap());
}

fn prime_factors(n: &u64) -> Vec<u64> {
    let mut factors: Vec<u64> = Vec::new();
    let mut m: u64 = *n;
    let root = (*n as f64).sqrt() as u64;

    for i in 2..root {
        if m % i == 0 {
            factors.push(i);
            m /= i;
        }
    }
    factors
}
