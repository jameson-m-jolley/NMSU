const std = @import("std");
const testing = std.testing;

export fn add(a: i32, b: i32) i32 {
    return a + b;
}

pub fn salution() type{
    return struct {

        // wee need to have a list of moves to to compare as we brute forse the salution
        // we have ant that has a location and of a cube a
        // we have 3d points that we can represent as a vector of booleans
        //
        //we can use use bools to test this becaus the point [1,1,1] would be the oposit side of the cube
        //
        points: [3]bool = .{false,false,false},// we will have 0 as the defalt for testing
        prng: std.rand.DefaultPrng = undefined,
        prev: std.ArrayList([3]bool) = undefined,

        // we then can use a seed to make randome movements that are corect

        pub fn init(_seed:u64, alloc: std.mem.Allocator) @This(){
            return .{
                .prng = std.rand.DefaultPrng.init(blk: {
                    var seed: u64 = _seed;
                    try std.posix.getrandom(std.mem.asBytes(&seed));
                    break :blk seed;
                }),
                .prev = std.ArrayList([3]bool).init(alloc),
            };
        }//end of init
        //

        pub fn makemove(self: *@This()) !bool{
            self.prev.append(self.points);// adds to visit
            for(0..self.prev.capacity)|i|{
                _=i;

            }
            return false;
        }




    };
}


test "basic add functionality" {
    try testing.expect(add(3, 7) == 10);
}
