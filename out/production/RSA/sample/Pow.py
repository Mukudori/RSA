

if __name__=='__main__':
    fi = open('buf_inp.txt', 'r')
    l = [line for line in fi]
    fi.close()
    c = int(l[0])
    n = int(l[1])

    val = pow(c,n) // 33
    fo = open('buf_out.txt', 'w')
    fo.write(str(val))
    fo.close()