pub fn solve() {
    let result: u32 = Fib::new()
        .filter(|&n| n % 2 == 0)
        .take_while(|&n| n < 4000000)
        .sum();
    println!("{}", result);
}

struct Fib {
    n0: u32,
    n1: u32,
}

impl Fib {
    pub fn new() -> Self {
        Self { n0: 0, n1: 1 }
    }
}

impl Iterator for Fib {
    type Item = u32;
    fn next(&mut self) -> Option<Self::Item> {
        let m = self.n0 + self.n1;
        self.n0 = self.n1;
        self.n1 = m;
        Some(m)
    }
}
