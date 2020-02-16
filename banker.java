
#include <stdio.h>
struct file
{
    int all[10];
    int need[10];
    int max[10];
    int flag;
};
void main()
{
    struct file f[10];
    int f1;
    int i,j,k,p,b,g,n,r,cnt=0,id;
    int avail[10],seq[10];
    printf("enter number of the processes---");
    scanf("%d",&n);
    printf("enter number of the resources---");
    scanf("%d",&r);
    for(i=0;i<n;i++)
    {
        printf("enter the details p%d",i);
        printf("enter allocation\t---\t");
        for(j=0;j<r;j++)
        {
            scanf("%d",&f[i].all[j]);
            printf("enter the max\t\t----\t");
            for(j=0;j<r;j++)
            {
                scanf("%d",&f[i].max[j]);
                f[i].flag=0;
            }
        }
    }
    printf("enter the avaliable resources\t---\t");
    for(i=0;i<r;i++)
    {
        scanf("%d",&avail[10]);
    }
    for(i=0;i<n;i++)
    {
        for(j=0;j<r;j++)
        {
            f[i].need[j]=f[i].max[j]-f[i].all[j];
            if(f[i].need[j]<0)
            f[i].need[j]=0;
        }
    }
    cnt=0;
    f1=0;
    while(cnt!=n)
    {
        g=0;
        for(j=0;j<n;j++)
        {
            if(f[j].flag==0)
            {
                b=0;
                for(p=0;p<r;p++)
                {
                    if(avail[p]>=f[j].need[p])
                    b=b+1;
                    else
                    b=b-1;
                }
                if(b==r)
                {
                printf("\n p%d is visited",j);
                seq[f1++]=j;
                f[j].flag=1;
                for(k=0;k<r;k++)
                avail[k]=avail[k]+f[j].all[k];
                cnt=cnt+1;
                printf("(");
                for(k=0;k<r;k++)
                printf("%3d",avail[k]);
                printf(")");
                g=1;
                }
            }
            
        }
        if(g==0)
        {
            printf("\n REQUEST NOT GRANTED ----DEADLOCK OCCURED");
            printf("\n SYSTEM IS IN UNSAFE STATE");
            goto y;
        }
    }
  printf("\n SYSTEM IS IN SAFE STATE");
  printf("\n THE SAFE SEQUENCE IS---(");
  for(i=0;i<f1;i++)
  printf("p%d",seq[i]);
  printf(")");
  y:printf("\nPROCESS\tallocated\t max\t need\n");
  for(i=0;i<n;i++)
  {
      printf("p%d\t",i);
      for(j=0;j<r;j++)
      printf("%6d",f[i].all[j]);
       for(j=0;j<r;j++)
      printf("%6d",f[i].max[j]);
       for(j=0;j<r;j++)
      printf("%6d",f[i].need[j]);
     printf("\n");
  }
}
